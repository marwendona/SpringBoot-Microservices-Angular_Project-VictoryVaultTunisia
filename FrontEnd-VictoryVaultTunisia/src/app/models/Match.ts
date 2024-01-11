export class MatchSeason {
  id!: number;
  nameTeamHome!: ;
  nameTeamAway!: ;
  scoreTeamHome!: number;
  scoreTeamAway!: number;
  roundId!: number;
}

export class Match {
  id!:number;

  stadiumId!:number;
  stadiumName!:string;
  stadiumCapacity!:number;

  refereeId!:number;
  refereeFirstName!:string;
  refereeLastName!:string;
  refereeNationality!:string;

  date!:Date;
  spectatorNumber!:number;

  teamHomeScorers!:any[];
  teamAwayScorers!:any[];

  lineupHomeId!:number;
  lineupHomeTeamId!:number;
  lineupHomeTeamName!:string;

  lineupAwayId!:number;
  lineupAwayTeamId!:number;
  lineupAwayTeamName!:string;

  replacements!:any[];

  roundId!:number;

}