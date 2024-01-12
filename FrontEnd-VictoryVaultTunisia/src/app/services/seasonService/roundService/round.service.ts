import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Round } from 'src/app/models/Round';

@Injectable({
  providedIn: 'root'
})
export class RoundService {

  constructor(private _httpClient: HttpClient) {}
  roundAPI= `/season-service/rounds`
  
  addRound(round:Round): Observable<any> {
    return this._httpClient.post<any>(this.roundAPI+`/${round.seasonId}`, round);
  }

  getRound():Observable<Round[]> {
    return this._httpClient.get<Round[]>(this.roundAPI);
  }

  editRound(round:Round,roundId:number){
    return this._httpClient.put<any>(`${this.roundAPI}/${roundId}`, round);
  }

  deleteRound(roundId:number){
    return this._httpClient.delete(`${this.roundAPI}/${roundId}`)
  }
}
