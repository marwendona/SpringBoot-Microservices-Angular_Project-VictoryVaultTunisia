import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lineups } from 'src/app/models/Lineups';

@Injectable({
  providedIn: 'root'
})
export class LineupService {

  constructor(private _httpClient: HttpClient) {}
  lineupAPI= `/matches-service/lineups`

  addLineup(lineup:Lineups): Observable<any> {
    return this._httpClient.post<any>(`${this.lineupAPI}`, lineup);
  }

  getLineupByTeam():Observable<Lineups[]>{
      return this._httpClient.get<Lineups[]>(this.lineupAPI);
    }
}
