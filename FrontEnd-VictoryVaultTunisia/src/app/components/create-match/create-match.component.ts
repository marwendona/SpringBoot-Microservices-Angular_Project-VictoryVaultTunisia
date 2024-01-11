import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Match } from 'src/app/models/Match';
import { Referee } from 'src/app/models/Referee';
import { Season } from 'src/app/models/Season';
import { Stadium } from 'src/app/models/Stadium';
import { MatchService } from 'src/app/services/matchServices/matchService/match.service';

import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { RefereeService } from 'src/app/services/matchServices/refereeService/referee.service';
import { StadiumService } from 'src/app/services/matchServices/stadiumService/stadium.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';
import { SeasonService } from 'src/app/services/seasonService/seasonService/season.service';

@Component({
  selector: 'app-create-match',
  templateUrl: './create-match.component.html',
  styleUrls: ['./create-match.component.css']
})
export class CreateMatchComponent implements OnInit{

seasons!: Season[];
roundData: any;


onSelectTeamHome() {
throw new Error('Method not implemented.');
}
stadiumData: any;
refereeData!: Referee[];
teamData!:any;
matchForm!: FormGroup;

stadium!:Stadium;
referee!:Referee;
constructor(private seasonService:SeasonService,private router:Router,private refereeService:RefereeService,private stadiumService:StadiumService,private teamService:TeamService,private matchService:MatchService){}

 async ngOnInit(): Promise<void> {
    await this.getReferee();
    await this.getStadium();
    await this.getTeam();
    await this.getSeason();
    this.initMatchForm();
  }


async getReferee(){
  this.refereeService.getReferee().subscribe(refereeData=>{
    this.refereeData=refereeData.content;
  })
}

async getStadium(){
  this.stadiumService.getStadiums().subscribe(stadiumData=>{
    this.stadiumData=stadiumData.content;    
  })
}

async getTeam(){
  this.teamService.getTeams().subscribe(teamData=>{
    this.teamData=teamData.content
  })
}

async getSeason(){
 this.seasonService.getSeason().subscribe(seasons=>{
  this.seasons = seasons ;
 })
}

loadround(){
  this.roundData = this.seasons.filter(season=>season.id == this.matchForm.value.season)[0].rounds
}

initMatchForm(){
  this.matchForm = new FormGroup({
    season: new FormControl('', Validators.required),
    round: new FormControl('', Validators.required),
    spectators: new FormControl('', Validators.required),
    referee: new FormControl('', Validators.required),
    date: new FormControl('', Validators.required), 
    stadium: new FormControl('', Validators.required),
  });
}


addMatch() {
  this.stadiumService.getStadiumById(this.matchForm.value.stadium).subscribe(stadium=>{
    this.stadium=stadium;
 
  console.log(this.stadium);
    this.refereeService.getRefereeById(this.matchForm.value.referee).subscribe(referee=>{
      this.referee=referee
    
  
  const match:Match={
    id: 0,
    stadiumId: this.stadium.id,
    stadiumName: this.stadium.name,
    stadiumCapacity: this.stadium.capacity,
    refereeId: this.matchForm.value.referee,
    refereeFirstName: this.referee.firstName,
    refereeLastName: this.referee.lastName,
    refereeNationality: this.referee.nationality,
    date: this.matchForm.value.date,
    spectatorNumber: this.matchForm.value.spectators,
    teamHomeScorers: [],
    teamAwayScorers: [],
    lineupHomeId: 0,
    lineupHomeTeamId: 0,
    lineupHomeTeamName: '',
    lineupAwayId: 0,
    lineupAwayTeamId: 0,
    lineupAwayTeamName: '',
    replacements: [],
    roundId: this.matchForm.value.round
  }
    console.log("maa",match);
    this.matchService.addMatch(match).subscribe(()=>{
      console.log("success");
      this.router.navigate(['match'])
      
    })

})


})

  // this.matchService.addMatch(match).subscribe(()=>{
  //   console.log("success");
    

}

  playerSelections: { [key: string]: number | undefined } = {};

  onSelectOption(event: any, key: string) {
    const selectedPlayerId = parseInt(event.target.value, 10);
    console.log(`Selected Player ID for ${key}:`, selectedPlayerId);

    // Update the dictionary with the selected player's ID
    this.playerSelections[key] = selectedPlayerId;
    console.log('Updated Player Selections:', this.playerSelections);
    
  }
  hiddenPlayers = [true, true];
  
  onSelectPlayer1(): void {
    this.hiddenPlayers[0] = false; // Assign a boolean value, not a string
    console.log(this.hiddenPlayers);
  }

  isPlayerSelected(playerId: number): boolean {
    // Check if the player has been selected in any of the selects
    return Object.values(this.playerSelections).includes(playerId);
  }
  onSelectPlayern(playerIndex: number){
    this.hiddenPlayers[playerIndex+1] = false;

  }
}
