import { Component } from '@angular/core';
import { MatchSeason } from 'src/app/models/Match';
import { Round } from 'src/app/models/Round';
import { Season } from 'src/app/models/Season';
import { Standing } from 'src/app/models/Standing';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
nextSeason() {
  let indexcurrentSeson:number= this.Seasons.indexOf(this.currentSeason);
  if(indexcurrentSeson != this.Seasons.length-1){
    this.currentSeason=this.Seasons[indexcurrentSeson+1];
  }
}
previousSeason() {
  let indexcurrentSeson:number= this.Seasons.indexOf(this.currentSeason);
  if(indexcurrentSeson != 0){
    this.currentSeason=this.Seasons[indexcurrentSeson-1];
  }
}
previousRound() {
  let indexcurrentRound:number= this.rounds.indexOf(this.currentRound);
  if(indexcurrentRound != 0){
    this.currentRound=this.rounds[indexcurrentRound-1];
  }
}
nextRound() {
  let indexcurrentRound:number= this.rounds.indexOf(this.currentRound);
  if(indexcurrentRound != this.rounds.length-1){
    this.currentRound=this.rounds[indexcurrentRound+1];
  }
}

  matches:MatchSeason[] = [
    { id: 1, nameTeamAway: 'CSS', scoreTeamAway:0, scoreTeamHome:0, nameTeamHome: 'ESS' ,roundId:1},
    { id: 1, nameTeamAway: 'CSS', scoreTeamAway:5, scoreTeamHome:8, nameTeamHome: 'ESS' ,roundId:1},

    { id: 1, nameTeamAway: 'CSS', scoreTeamAway:8, scoreTeamHome:9, nameTeamHome: 'ESS' ,roundId:1},

    { id: 1, nameTeamAway: 'CSS', scoreTeamAway:0, scoreTeamHome:5, nameTeamHome: 'ESS' ,roundId:1},

  ]
  rounds:Round[]=[
    {id:1, name: "Round 1",roundNumber:1,matches:this.matches,seasonId:5},
    {id:1, name: "Round 1",roundNumber:2,matches:this.matches,seasonId:5},
    {id:1, name: "Round 1",roundNumber:3,matches:this.matches,seasonId:5},
  ]
  currentRound:Round = this.rounds[this.rounds.length-1]
  standings:Standing[]=[
    {id:1, rank: 1, score: 10, teamId: 1, teamName: "Team 1", seasonId: 1, },
    {id:1, rank: 2, score:8, teamId: 1, teamName: "Team 2", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
    {id:1, rank: 3, score: 0, teamId: 1, teamName: "Team 3", seasonId: 1, },
  ]
  Seasons:Season[]=[
    {id:1, name: "Season 1",rounds:this.rounds,standings:this.standings},
    {id:2, name: "Season 2",rounds:this.rounds,standings:this.standings},
    {id:3, name: "Season 3",rounds:this.rounds,standings:this.standings},
  ]
  currentSeason:Season = this.Seasons[this.Seasons.length-1]

}
