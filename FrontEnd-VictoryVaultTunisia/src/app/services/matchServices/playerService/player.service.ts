import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Players } from 'src/app/models/Players';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  constructor(private _httpClient: HttpClient) {}
  playersAPI= `http://localhost:8082/players`
  
  addPlayers(player:Players): Observable<any> {
    return this._httpClient.post<any>(`${this.playersAPI}`, player);
  }

  getPlayers():Observable<Players[]> {
    return this._httpClient.get<Players[]>(this.playersAPI);
  }
}
