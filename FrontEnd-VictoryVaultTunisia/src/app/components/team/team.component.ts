import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { NavigationExtras, Router } from '@angular/router';
import { Team } from 'src/app/models/Team';
import { TeamWithCoachName } from 'src/app/models/team/TeamWithCoachName';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

selectedChoice: any;
addTeam() {
throw new Error('Method not implemented.');
}
  dataTeams!: CdkTableDataSourceInput<any>;
  _dataTeams!: any[];

  isRowHovered = false;
  displayedColumns: string[] = ['name', 'coach','action'];
  nameError: any;
  teamsForm!: FormGroup<any>;

  constructor(private teamService:TeamService, private router: Router,private coachService:CoachService){}

  ngOnInit(): void {
    this.getTeams();

    console.log(this.dataTeams);
    
  }

  dataTeamsPrinciple:any[]=[];
  
getTeams(){
  this.teamService.getTeams().subscribe(async (teams)=>{
    this.dataTeams=teams.content
    // console.log("first",typeof(this.dataTeams));

    // await teams.content.forEach(team=>{
    //   console.log("mid");

    //  this.coachService.getCoachById(team.coachId).subscribe(result => {
    //     const newTeam:TeamWithCoachName={
    //       id: team.id,
    //       name: team.name,
    //       players: [],
    //       coachId: team.coachId,
    //       coachName: result.firstName +" " +result.lastName 
    //     }
    //     this.dataTeamsPrinciple.push(newTeam)
    //   })
    //   // console.log(this.dataTeamsPrinciple);
      
    // })
    // console.log("sec");
    // console.log("prin",typeof(this.dataTeamsPrinciple));

    // this.dataTeams = this.dataTeamsPrinciple

  })
}

  onTeamClick(team: any) {
    // const data = { cin: team.cin };
    const navigationExtras: NavigationExtras = {
      queryParams: team,
    };
    this.router.navigate(['/editTeam'], navigationExtras).then(() => {
      window.location.reload();
    });
  }

  confirmDelete(TeamId:number): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d51d1d',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        // Call your delete function here
        this.deleteFunction(TeamId);
      }
    });
  }
  deleteFunction(teamID:number): void {
    this.teamService.deleteTeam(teamID).subscribe(()=>{
      Swal.fire({
        title: 'Deleted!',
        text: 'Your file has been deleted.',
        icon: 'success'
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.reload();
        }
      });
    
  
    })
   
  }


// configuration table
onRowHover(hovered: boolean) {
  this.isRowHovered = hovered;
}

}
