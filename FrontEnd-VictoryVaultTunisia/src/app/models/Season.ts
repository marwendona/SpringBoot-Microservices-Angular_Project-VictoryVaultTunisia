import { Round } from "./Round";
import { Standing } from "./Standing";

export class Season {
    id!:number;
    name:string='';
    rounds!:Round[];
    standings!:Standing[];
  }
  