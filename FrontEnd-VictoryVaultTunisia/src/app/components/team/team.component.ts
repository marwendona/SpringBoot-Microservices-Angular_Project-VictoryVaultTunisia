import { Component } from '@angular/core';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  displayedColumns: string[] = ['rang', 'rib','cin', 'solde'];
  staticData = [
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },

    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },
    { rib: '123456', client: { cin: 'ABC123' }, solde: 1000 },




    // Add more static data as needed
  ];

  dataComptes = this.staticData;
}
