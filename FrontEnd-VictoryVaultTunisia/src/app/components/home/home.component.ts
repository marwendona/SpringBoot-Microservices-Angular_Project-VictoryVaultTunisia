import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatchSeason } from 'src/app/models/Match';
import { Round } from 'src/app/models/Round';
import { Season } from 'src/app/models/Season';
import { Standing } from 'src/app/models/Standing';
import { RankingService } from 'src/app/services/seasonService/rankingService/ranking.service';
import { RoundService } from 'src/app/services/seasonService/roundService/round.service';
import { SeasonService } from 'src/app/services/seasonService/seasonService/season.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
rankForm!: FormGroup<any>;

  constructor(
    private seasonService: SeasonService,
    private roundService:RoundService,
    private standingService: RankingService 
    ) { }
  roundForm!: FormGroup<any>;
  seasonForm!: FormGroup<any>;
  matches!: MatchSeason[];
  rounds!: Round[] ;
  currentRound!: Round|undefined;
  standings!: Standing[];
  Seasons!: Season[];
  currentSeason!: Season;

  ngOnInit(): void {
    this.initFormAddAccount();
    this.initFormAddRound();
    this.initFormAddRank();
    this.getSeasons();
  }

  initFormAddAccount() {
    this.seasonForm = new FormGroup({
      name: new FormControl('', Validators.required),
    });
  }
  initFormAddRound() {
    this.roundForm = new FormGroup({
      name: new FormControl('', Validators.required),
      roundNumber: new FormControl('', Validators.required),
    });
  }
  initFormAddRank() {
    this.rankForm = new FormGroup({
      rank: new FormControl('', Validators.required),
      score: new FormControl('', Validators.required),
      teamName: new FormControl('', Validators.required),
    });
  }
  getSeasons() {
    this.seasonService.getSeason().subscribe((data) => {
      this.Seasons = data;
      this.currentSeason = this.Seasons[this.Seasons.length - 1];
      this.rounds = this.currentSeason.rounds
      this.currentRound = this.rounds[this.rounds.length - 1];
      this.standings = this.currentSeason.generalStanding
      console.log(this.currentSeason);
      
    });
  }
  addSeason() {
    var season:Season = {
      id: 0,
      name: this.seasonForm.value.name,
      rounds: [],
      generalStanding: []
    }
    this.seasonService.addSeason(this.seasonForm.value).subscribe((data) => {
      this.getSeasons();
      window.location.reload();
    });
  }
  addRound() {
    let round:Round = {
      id: 0,
      name: this.roundForm.value.name,
      roundNumber: this.roundForm.value.roundNumber,
      matches:[],
      seasonId: this.currentSeason?.id || 0
    }
    this.roundService.addRound(round).subscribe((data) => {
      this.getSeasons();
      window.location.reload();
    });
  }
  addRank() {
    //TODO use dynamic teamId
    let rank:Standing = {
      id: 0,
      rank: this.rankForm.value.rank,
      score: this.rankForm.value.score,
      teamName: this.rankForm.value.teamName,
      seasonId: this.currentSeason?.id || 0,
      teamId: 1
    }
    this.standingService.addStanding(rank).subscribe((data) => {
      this.getSeasons();
      window.location.reload();
    });
    }
  nextSeason() {
    if (this.currentSeason)
   { let indexcurrentSeson: number = this.Seasons.indexOf(this.currentSeason);
    if (indexcurrentSeson != this.Seasons.length - 1) {
      this.currentSeason = this.Seasons[indexcurrentSeson + 1];
      if(this.currentSeason.rounds){
        this.rounds = this.currentSeason.rounds
        this.currentRound = this.rounds[this.rounds.length - 1];
        this.standings = this.currentSeason.generalStanding
        }
        else{
          this.currentRound = undefined
        }
    }
    
  }
  }
  previousSeason() {
    if (this.currentSeason)
   { let indexcurrentSeson: number = this.Seasons.indexOf(this.currentSeason);
    if (indexcurrentSeson != 0) {
      this.currentSeason = this.Seasons[indexcurrentSeson - 1];
      if(this.currentSeason.rounds){
      this.rounds = this.currentSeason.rounds
      this.currentRound = this.rounds[this.rounds.length - 1];
      this.standings = this.currentSeason.generalStanding
      }
      else{
        this.currentRound = undefined
      }
    }}
  }
  previousRound() {
    if (this.currentRound)
    {let indexcurrentRound: number = this.rounds.indexOf(this.currentRound);
    if (indexcurrentRound != 0) {
      this.currentRound = this.rounds[indexcurrentRound - 1];
    }}
  }
  nextRound() {
    if (this.currentRound)
   { let indexcurrentRound: number = this.rounds.indexOf(this.currentRound);
    if (indexcurrentRound != this.rounds.length - 1) {
      this.currentRound = this.rounds[indexcurrentRound + 1];
    }}
  }



}
