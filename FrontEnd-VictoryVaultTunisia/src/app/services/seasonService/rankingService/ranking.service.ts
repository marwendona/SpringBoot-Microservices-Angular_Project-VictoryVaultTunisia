import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Standing } from 'src/app/models/Standing';

@Injectable({
  providedIn: 'root'
})
export class RankingService {

  constructor(private _httpClient: HttpClient) {}
  standingAPI= `/season-service/standings`
  
  addStanding(standing:Standing): Observable<any> {
    return this._httpClient.post<any>(this.standingAPI+`/${standing.seasonId}`, standing);
  }

  getStanding():Observable<Standing[]> {
    return this._httpClient.get<Standing[]>(this.standingAPI);
  }

  editStanding(standing:Standing,standingId:number){
    return this._httpClient.put<any>(`${this.standingAPI}/${standingId}`, standing);
  }

  deleteStanding(standingId:number){
    return this._httpClient.delete(`${this.standingAPI}/${standingId}`)
  }
}
