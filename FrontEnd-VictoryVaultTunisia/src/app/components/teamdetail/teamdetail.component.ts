import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Coach } from 'src/app/models/Coach';
import { Players } from 'src/app/models/Players';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

@Component({
  selector: 'app-teamdetail',
  templateUrl: './teamdetail.component.html',
  styleUrls: ['./teamdetail.component.css']
})
export class TeamdetailComponent implements OnInit{
  dataPlayers!: any;
  paramsTeam: any;
  hidden:boolean=true;
  coach!:Coach;
  constructor(private teamService:TeamService, private route: ActivatedRoute, private coachService:CoachService){}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.paramsTeam = params;
    //getPlayers
    this.getPlayers(this.paramsTeam);
    //getCoach
    this.getCoach(this.paramsTeam);
    })
  }

getPlayers(paramsTeam:any){
    this.teamService.getPlayersByTeams(paramsTeam.id).subscribe(players=>{
      this.dataPlayers = new MatTableDataSource<Players>(players);
      this.dataPlayers = this.dataPlayers.filteredData;
      if(this.dataPlayers[0]==null){
        this.hidden=false;
      }
    })
}

getCoach(paramsTeam:any){
  this.coachService.getCoachById(paramsTeam.coachId).subscribe(coach=>{
   this.coach=coach;
  })
}

deletePlayer(arg0: any) {
console.log(arg0)
}
  editPlayer(arg0: any) {
}

}