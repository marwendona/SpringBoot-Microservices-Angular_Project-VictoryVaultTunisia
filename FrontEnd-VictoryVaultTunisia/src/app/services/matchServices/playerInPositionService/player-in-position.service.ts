import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlayerInPosition } from 'src/app/models/PlayerInPosition';

@Injectable({
  providedIn: 'root'
})
export class PlayerInPositionService {

  constructor(private _httpClient: HttpClient) {}
  playersInPositionAPI= `/matches-service/playerinposition`

  addPlayersInPosition(playerInPosition:PlayerInPosition): Observable<any> {
    return this._httpClient.post<any>(`${this.playersInPositionAPI}`, playerInPosition);
  }


  // getAllPlayers():Observable<Players[]>{
  //   return this._httpClient.get<Players[]>(this.playersAPI);
  // }
}
