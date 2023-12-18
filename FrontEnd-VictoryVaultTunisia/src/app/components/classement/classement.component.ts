import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-classement',
  templateUrl: './classement.component.html',
  styleUrls: ['./classement.component.css']
})
export class ClassementComponent {
  displayedColumns: string[] = ['rang', 'rib','cin', 'solde'];
  staticData = [
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    // Add more static data as needed
  ];

  dataComptes = this.staticData;
}
