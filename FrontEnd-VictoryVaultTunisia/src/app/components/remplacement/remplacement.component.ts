import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-remplacement',
  templateUrl: './remplacement.component.html',
  styleUrls: ['./remplacement.component.css'],
})
export class RemplacementComponent implements OnInit{
  remplacementForm!: FormGroup<any>;
  dataRemplacement!: CdkTableDataSourceInput<any>;
  isRowHovered = false;
  displayedColumns: string[] = ['rang','firstName','lastName','nationality','team','action'];

  constructor(){}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  addRemplacement() {
    throw new Error('Method not implemented.');
  }

  confirmDelete(arg0: any) {
    throw new Error('Method not implemented.');
  }
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
}
