import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-classement',
  templateUrl: './classement.component.html',
  styleUrls: ['./classement.component.css']
})
export class ClassementComponent {
  displayedColumns: string[] = ['équipe1', 'Score','équipe2'];
  staticDataJournee = [
    {id:1,equipe1: 'CSS', Score: "0-0", equipe2: 'ESS' },
    {id:2, equipe1: 'CA', Score: "4-0", equipe2: 'ST' },
    {id:1,equipe1: 'CSS', Score: "0-0", equipe2: 'ESS' },
    {id:2, equipe1: 'CA', Score: "4-0", equipe2: 'ST' },


  ];
  dataResultJournee = this.staticDataJournee;
  isRowHovered = false;
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
  onRowClick(row: any){
    console.log(row.id)
  }
}
