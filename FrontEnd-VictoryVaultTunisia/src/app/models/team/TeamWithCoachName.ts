import { Players } from "../Players";

export class TeamWithCoachName {
    id!:number;
    name:string='';
    players!:Players[]
    coachId!:number
    coachName:string='';
  }
