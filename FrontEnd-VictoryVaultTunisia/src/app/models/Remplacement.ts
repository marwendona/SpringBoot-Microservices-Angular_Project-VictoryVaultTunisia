import { Match } from "./Match";
import { PlayerInPosition } from "./PlayerInPosition";

export class Remplacement {
    id!:number;
    playerIn!:PlayerInPosition;
    playerOut!:PlayerInPosition;
    replacementTime!:number;
    match!:Match;

  }
  