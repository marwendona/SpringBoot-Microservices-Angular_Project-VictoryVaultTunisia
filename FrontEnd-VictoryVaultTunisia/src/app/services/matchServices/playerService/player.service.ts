import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from 'src/app/models/Page';
import { Players } from 'src/app/models/Players';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  constructor(private _httpClient: HttpClient) {}
  playersAPI= `/matches-service/players`

  addPlayers(player:Players): Observable<any> {
    return this._httpClient.post<any>(`${this.playersAPI}`, player);
  }

  getPlayers(size:number=10,page:number=0):Observable<Page<Players>> {
    let params = new HttpParams();
    params = params.set('size', size);
    params = params.set('page', page);
    return this._httpClient.get<Page<Players>>(this.playersAPI,{params});
  }
  
  getPlayerById(playerId:number):Observable<Players>{
    return this._httpClient.get<Players>(`${this.playersAPI}/${playerId}`);
  }
  editPlayer(player:Players,playerId:number){
    return this._httpClient.put<any>(`${this.playersAPI}/${playerId}`, player);
  }

  deletePlayer(playerId:number){
    return this._httpClient.delete(`${this.playersAPI}/${playerId}`)
  }

  modifyPlayerTeam(playerId:number){
    // return this._httpClient.put<any>(`${this.playersAPI}/team`)
  }

  deletePlayerFromTeam(playerId:number,TeamId:number){
    return this._httpClient.delete(`${this.playersAPI}/${playerId}/${TeamId}`)
  }
}
