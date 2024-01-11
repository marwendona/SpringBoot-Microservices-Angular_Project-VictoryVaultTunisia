import { Lineups } from "./Lineups";
import { Referee } from "./Referee";
import { Remplacement } from "./Remplacement";
import { Stadium } from "./Stadium";

export class Match {
  id!:number;
  stadium!:Stadium;
  referee!:Referee;
  date!:Date;
  spectatorNumber!:number;
  lineupHomes!:Lineups;
  lineupAway!:Lineups;
  replacements!:Remplacement[];
  roundId!:number;
}
  