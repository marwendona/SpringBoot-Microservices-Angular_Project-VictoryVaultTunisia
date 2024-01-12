import { Players } from "./Players";

export class Team {
    id!:number;
    name:string='';
    players!:Players[]
    coachId!:number
  }
