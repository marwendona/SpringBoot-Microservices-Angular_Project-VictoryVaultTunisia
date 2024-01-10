import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { NavigationExtras, Router } from '@angular/router';
import { Team } from 'src/app/models/Team';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';

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
  dataTeams!: any;
  isRowHovered = false;
  displayedColumns: string[] = ['name', 'coach','action'];
  nameError: any;
  teamsForm!: FormGroup<any>;

  constructor(private teamService:TeamService, private router: Router){}

  ngOnInit(): void {
    this.getTeams();
  }

getTeams(){
  this.teamService.getTeams().subscribe((teams)=>{
    this.dataTeams = new MatTableDataSource<Team>(teams);
    this.dataTeams = this.dataTeams._data.value.content;
  })
}

  onTeamClick(team: any) {
    // const data = { cin: team.cin };
    const navigationExtras: NavigationExtras = {
      queryParams: team,
    };
    this.router.navigate(['/teamDetail'], navigationExtras).then(() => {
      window.location.reload();
    });
  }
// configuration table
onRowHover(hovered: boolean) {
  this.isRowHovered = hovered;
}

}
