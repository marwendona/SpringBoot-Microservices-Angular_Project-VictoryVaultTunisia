import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Season } from 'src/app/models/Season';

@Injectable({
  providedIn: 'root'
})
export class SeasonService {

  constructor(private _httpClient: HttpClient) {}
  seasonAPI= `/season-service/seasons`
  
  addSeason(season:Season): Observable<any> {
    return this._httpClient.post<any>(this.seasonAPI, season);
  }

  getSeason():Observable<Season[]> {
    return this._httpClient.get<Season[]>(this.seasonAPI);
  }

  editSeason(season:Season,seasonId:number){
    return this._httpClient.put<any>(`${this.seasonAPI}/${seasonId}`, season);
  }

  deleteSeason(seasonId:number){
    return this._httpClient.delete(`${this.seasonAPI}/${seasonId}`)
  }
}
