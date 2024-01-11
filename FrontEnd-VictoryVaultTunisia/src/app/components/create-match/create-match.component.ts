import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Match } from 'src/app/models/Match';
import { Referee } from 'src/app/models/Referee';
import { MatchService } from 'src/app/services/matchServices/matchService/match.service';

import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { RefereeService } from 'src/app/services/matchServices/refereeService/referee.service';
import { StadiumService } from 'src/app/services/matchServices/stadiumService/stadium.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

@Component({
  selector: 'app-create-match',
  templateUrl: './create-match.component.html',
  styleUrls: ['./create-match.component.css']
})
export class CreateMatchComponent implements OnInit{
onSelectTeamHome() {
throw new Error('Method not implemented.');
}
stadiumData: any;
refereeData!: Referee[];
teamData!:any;
matchForm!: FormGroup;


constructor(private refereeService:RefereeService,private stadiumService:StadiumService,private teamService:TeamService,private matchService:MatchService){}

 async ngOnInit(): Promise<void> {
    await this.getReferee();
    await this.getStadium();
    await this.getTeam();
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
    console.log( this.stadiumData);
    
  })
}

async getTeam(){
  this.teamService.getTeams().subscribe(teamData=>{
    this.teamData=teamData.content
  })
}

initMatchForm(){
  this.matchForm = new FormGroup({
    spectators: new FormControl('', Validators.required),
    referee: new FormControl('', Validators.required),
    date: new FormControl('', Validators.required), 
    stadium: new FormControl('', Validators.required),
  });
}


addMatch() {

  
  const match:Match={
    id: 0,
    stadiumId: this.matchForm.value.stadium,
    stadiumName: "",
    stadiumCapacity: 0,
    refereeId: this.matchForm.value.referee,
    refereeFirstName: '',
    refereeLastName: '',
    refereeNationality: '',
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
    roundId: 0
  }
console.log(match);



  this.matchService.addMatch(match).subscribe(()=>{
    console.log("success");
    
  })
  console.log(match);

  console.log(match);
  

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
