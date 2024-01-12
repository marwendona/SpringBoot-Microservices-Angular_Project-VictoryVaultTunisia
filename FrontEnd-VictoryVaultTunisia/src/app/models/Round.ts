import { MatchSeason } from "./Match";

export class Round {
    id!:number;
    name!:string;
    roundNumber!:number;
    matches!:MatchSeason[];
    seasonId!:number;
  }
  