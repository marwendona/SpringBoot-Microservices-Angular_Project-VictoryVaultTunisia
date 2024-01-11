import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  matches = [
    { id: 1, equipe1: 'CSS', score: "0-0", equipe2: 'ESS' ,date:"10:00"},
    { id: 2, equipe1: 'CA', score: "4-0", equipe2: 'ST' ,date:"10:00"},
    { id: 3, equipe1: 'CSS', score: "0-0", equipe2: 'ESS' ,date:"10:00"},
    { id: 4, equipe1: 'CA', score: "4-0", equipe2: 'ST' ,date:"10:00"}
  ]

}
