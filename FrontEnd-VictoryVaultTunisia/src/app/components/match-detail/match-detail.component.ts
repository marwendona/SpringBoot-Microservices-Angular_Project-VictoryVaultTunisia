import { Component, OnInit } from '@angular/core';
import { Players } from 'src/app/models/Players';
import { Team } from 'src/app/models/Team';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

@Component({
  selector: 'app-match-detail',
  templateUrl: './match-detail.component.html',
  styleUrls: ['./match-detail.component.css']
})
export class MatchDetailComponent implements OnInit{
  players!:Players[];
  teams!:Team[];
  constructor(private playerService:PlayerService,private teamService:TeamService){}

   ngOnInit(){
    this.getTeams();
  }

 getTeams(){
  this.teamService.getTeams().subscribe(teams=>{
    this.teams=teams.content
  })
 }
  
}
