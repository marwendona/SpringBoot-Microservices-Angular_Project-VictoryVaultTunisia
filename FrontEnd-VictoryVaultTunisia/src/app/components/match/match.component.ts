import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import { MatchService } from 'src/app/services/matchServices/matchService/match.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent {
  
selectedChoice: any;
addTeam() {
throw new Error('Method not implemented.' );
}
MatchData!: CdkTableDataSourceInput<any>;
  _dataTeams!: any[];

  isRowHovered = false;
  displayedColumns: string[] = ['name', 'Stadium','Referee','date','Spectator','Home','Away','action'];
  nameError: any;
  teamsForm!: FormGroup<any>;

  constructor(private teamService:TeamService, private router: Router,private coachService:CoachService,private matchService:MatchService){}

  ngOnInit(): void {
    this.getMatch();

    console.log(this.MatchData);
    
  }

  dataTeamsPrinciple:any[]=[];


getMatch(){
  this.matchService.getMatch().subscribe(matchData=>{
    this.MatchData=matchData.content;
  })
}

onMatchClick(team: any) {
    // const data = { cin: team.cin };
    const navigationExtras: NavigationExtras = {
      queryParams: team,
    };
    this.router.navigate(['/matchDetail'], navigationExtras).then(() => {
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
    this.matchService.deleteTeam(teamID).subscribe(()=>{
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
