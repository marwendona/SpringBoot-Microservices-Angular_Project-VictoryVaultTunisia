import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Lineups } from 'src/app/models/Lineups';
import { PlayerInPosition } from 'src/app/models/PlayerInPosition';
import { PlayerInPositionFirst } from 'src/app/models/PlayerInPositionFirst';
import { Players } from 'src/app/models/Players';
import { Team } from 'src/app/models/Team';
import { LineupService } from 'src/app/services/matchServices/lineupService/lineup.service';
import { PlayerInPositionService } from 'src/app/services/matchServices/playerInPositionService/player-in-position.service';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

@Component({
  selector: 'app-match-detail',
  templateUrl: './match-detail.component.html',
  styleUrls: ['./match-detail.component.css']
})
export class MatchDetailComponent implements OnInit{

  playersHome!:Players[];
  playersAway!:Players[];

  teams!:Team[];
  MatchFormAffect!: FormGroup;
  constructor(private lineupService:LineupService,private playerService:PlayerService,private teamService:TeamService,private playerInPosition:PlayerInPositionService){}

   async ngOnInit(){
    await this.getTeams();
    this.initMatchForm();
  }

 async getTeams(){
  this.teamService.getTeams().subscribe(teams=>{
    this.teams=teams.content
  })
 }
  initMatchForm(){
    this.MatchFormAffect = new FormGroup({
      TeamHome: new FormControl('', Validators.required),
      TeamAway: new FormControl('', Validators.required),
      playerHome1: new FormControl('', Validators.required),
      playerHome2: new FormControl('', Validators.required),
      playerHome3: new FormControl('', Validators.required),
      playerHome4: new FormControl('', Validators.required),
      playerHome5: new FormControl('', Validators.required),
      playerHome6: new FormControl('', Validators.required),
      playerHome7: new FormControl('', Validators.required),
      playerHome8: new FormControl('', Validators.required),
      playerHome9: new FormControl('', Validators.required),
      playerHome10: new FormControl('', Validators.required),
      playerHome11: new FormControl('', Validators.required),
      OptionplayerHome1: new FormControl('', Validators.required),
      OptionplayerHome2: new FormControl('', Validators.required),
      OptionplayerHome3: new FormControl('', Validators.required),
      OptionplayerHome4: new FormControl('', Validators.required),
      OptionplayerHome5: new FormControl('', Validators.required),
      OptionplayerHome6: new FormControl('', Validators.required),
      OptionplayerHome7: new FormControl('', Validators.required),
      OptionplayerHome8: new FormControl('', Validators.required),
      OptionplayerHome9: new FormControl('', Validators.required),
      OptionplayerHome10: new FormControl('', Validators.required),
      OptionplayerHome11: new FormControl('', Validators.required),
      OptionplayeAway1: new FormControl('', Validators.required),
      OptionplayeAway2: new FormControl('', Validators.required),
      OptionplayeAway3: new FormControl('', Validators.required),
      OptionplayeAway4: new FormControl('', Validators.required),
      OptionplayeAway5: new FormControl('', Validators.required),
      OptionplayeAway6: new FormControl('', Validators.required),
      OptionplayeAway7: new FormControl('', Validators.required),
      OptionplayeAway8: new FormControl('', Validators.required),
      OptionplayeAway9: new FormControl('', Validators.required),
      OptionplayeAway10: new FormControl('', Validators.required),
      OptionplayeAway11: new FormControl('', Validators.required),
      playerAway1: new FormControl('', Validators.required),
      playerAway2: new FormControl('', Validators.required),
      playerAway3: new FormControl('', Validators.required),
      playerAway4: new FormControl('', Validators.required),
      playerAway5: new FormControl('', Validators.required),
      playerAway6: new FormControl('', Validators.required),
      playerAway7: new FormControl('', Validators.required),
      playerAway8: new FormControl('', Validators.required),
      playerAway9: new FormControl('', Validators.required),
      playerAway10: new FormControl('', Validators.required),
      playerAway11: new FormControl('', Validators.required),
  });
  }

  EditMatch() {
   console.log(this.MatchFormAffect.get("playerHome1")?.value)
   const lineupHome:Lineups={
    id: 0,
    teamId: Number(this.MatchFormAffect.value.TeamHome)
  }

  this.lineupService.addLineup(lineupHome).subscribe(result=>{})
   for (let i = 1; i <= 11; i++) {
    const playerValue = this.MatchFormAffect.get(`playerHome${i}`)?.value;
 
    const playerInPositionFirst:PlayerInPositionFirst={
      id: 0,
      position: this.MatchFormAffect.get(`OptionplayerHome${i}`)?.value,
      playerId: Number(this.MatchFormAffect.get(`playerHome${i}`)?.value),
      playerFirstName: '',
      playerLastName: '',
      playerNationality: '',
      lineupId: 38
    }

    console.log(`playerInPosition${i}`,playerInPositionFirst);
    this.playerInPosition.addPlayersInPosition(playerInPositionFirst).subscribe(()=>{
      console.log(`yes${i}`);
      
    })
}
const lineupAway:Lineups={
  id: 0,
  teamId: Number(this.MatchFormAffect.value.TeamAway)
}

this.lineupService.addLineup(lineupAway).subscribe(result=>{})

for (let i = 1; i <= 11; i++) {
  const playerValue = this.MatchFormAffect.get(`playerAway${i}`)?.value;

  const playerInPositionFirstAway:PlayerInPositionFirst={
    id: 0,
    position: this.MatchFormAffect.get(`OptionplayerAway${i}`)?.value,
    playerId: Number(this.MatchFormAffect.get(`playerAway${i}`)?.value),
    playerFirstName: '',
    playerLastName: '',
    playerNationality: '',
    lineupId: 38//hedhi el id lezm nkatchiwha
  }

  console.log(`playerInPosition${i}`,playerInPositionFirstAway);
  this.playerInPosition.addPlayersInPosition(playerInPositionFirstAway).subscribe(()=>{
    console.log(`yes${i}`);
    
  })
}






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
 
 onSelectTeamHome(): void {
  this.hiddenPlayers[0] = false;
  console.log(this.hiddenPlayers);
  this.teamService.getPlayersByTeams(this.MatchFormAffect.value.TeamHome).subscribe(playersHome=>{
    this.playersHome=playersHome
    console.log(playersHome);
    
  })

 }

 isTeamHomeSelected(playerId: number): boolean {
   // Check if the player has been selected in any of the selects
   return Object.values(this.playerSelections).includes(playerId);
 }
 onSelectTeamAway(playerIndex: number){
   this.hiddenPlayers[playerIndex+1] = false;
   this.teamService.getPlayersByTeams(this.MatchFormAffect.value.TeamAway).subscribe(playersAway=>{
    this.playersAway=playersAway
    console.log(playersAway);
    
  })
 }
}
