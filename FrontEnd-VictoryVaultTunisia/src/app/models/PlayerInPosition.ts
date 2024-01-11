import { Lineups } from "./Lineups";
import { Players } from "./Players";
import { Remplacement } from "./Remplacement";
import { scorers } from "./Scorer";

export class PlayerInPosition {
    id!:number;
    position:string='';
    player!:Players;
    lineup!:Lineups;
    scorers!:scorers[];
    playerIns!:Remplacement[];
    playerOuts!:Remplacement[];
  }
  