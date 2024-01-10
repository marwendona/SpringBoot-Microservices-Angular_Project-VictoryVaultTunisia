import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Coach } from 'src/app/models/Coach';
import { Players } from 'src/app/models/Players';
import { Team } from 'src/app/models/Team';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

@Component({
  selector: 'app-addteam',
  templateUrl: './addteam.component.html',
  styleUrls: ['./addteam.component.css']
})
export class AddteamComponent implements OnInit {

  teamForm!: FormGroup;
  dataCoach!: any;
  players!:any;
  selectedCoach: string = ''; // Initialize with the default value you want

  constructor(private coachService:CoachService, private playerService:PlayerService, private teamService:TeamService ,private router: Router){}

  ngOnInit(): void {
    this.initForm();
    this.getCoach();
    this.getPlayers();
    
  }
  initForm(){
    this.teamForm = new FormGroup({
      Name: new FormControl('', Validators.required),
      CoachId: new FormControl('', Validators.required),
      PL1: new FormControl('', Validators.required),
    });
  }

  async getCoach(){
     this.coachService.getCoach().subscribe(coachs => {
      this.dataCoach = new MatTableDataSource<Coach>(coachs);
      this.dataCoach = this.dataCoach._data.value.content
      console.log("this.coachs",this.dataCoach)
    })
  }

  selectedPlayerId: number | undefined;

  async getPlayers(){
     this.playerService.getPlayers().subscribe( players => {
      this.players = new MatTableDataSource<Players>(players);
      this.players = this.players._data.value.content
      console.log("this.players",this.players)
    })
  }
  // selectedChoices: string[] = [];
  playersChoosenIDs:number[] = [];
  playerSelections: { [key: string]: number | undefined } = {};

  onSelectOption(event: any, key: string) {
    const selectedPlayerId = parseInt(event.target.value, 10);
    console.log(`Selected Player ID for ${key}:`, selectedPlayerId);

    // Update the dictionary with the selected player's ID
    this.playerSelections[key] = selectedPlayerId;
    console.log('Updated Player Selections:', this.playerSelections);
    
  }

  hiddenPlayers = [true, true, true, true, true, true, true, true, true, true,
    true, true, true, true, true, true, true, true, true, true,true, true];
  
  onSelectPlayer1(): void {
    this.hiddenPlayers[0] = false; // Assign a boolean value, not a string
    console.log(this.hiddenPlayers);
  }
  
  isPlayerSelected(playerId: number): boolean {
    // Check if the player has been selected in any of the selects
    return Object.values(this.playerSelections).includes(playerId);
  }
  shouldHidePlayer(playerIndex: number): boolean {
    return this.hiddenPlayers[playerIndex];
  }
  
  onSelectPlayern(playerIndex: number){
    this.hiddenPlayers[playerIndex+1] = false;

  }
playersList:Players[]=[]

  addTeam() {
    const valuesList = Object.values(this.playerSelections);
console.log(valuesList)

valuesList.forEach(pl => {
  const __player : Players ={
    id: Number(pl),
    firstName: '',
    lastName: '',
    nationality: '',
    teamId: 0
  }
  this.playersList.push(__player)
})

    const team: Team = {
      id: 0,
      name: this.teamForm.value.Name,
      coachId: Number(this.teamForm.value.CoachId),
      players: this.playersList
    };

    if(team.coachId != 0){
    this.teamService.addTeams(team).subscribe(()=> {
      console.log("team added successfuly")
      this.router.navigate(['/team'])     
     },
      (error) => {
        alert("Error , mabe the coach is already busy!");
      })
    }
    else{
      alert('Please select Coach')
    }


    console.log(team)
    
  }
}
