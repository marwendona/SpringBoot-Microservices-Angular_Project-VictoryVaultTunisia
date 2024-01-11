import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-lineup',
  templateUrl: './lineup.component.html',
  styleUrls: ['./lineup.component.css']
})
export class LineupComponent {
  remplacementForm!: FormGroup<any>;
  dataLineup!: CdkTableDataSourceInput<any>;
  isRowHovered = false;
  displayedColumns: string[] = ['rang','firstName','lastName','nationality','team','action'];

  constructor(){}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  addLineup() {
    throw new Error('Method not implemented.');
  }
  
  confirmDelete(arg0: any) {
    throw new Error('Method not implemented.');
  }
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
}
