import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from 'src/app/models/Team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private _httpClient: HttpClient) {}
  teamAPI= `http://localhost:8082/teams`
  
  addTeams(team:Team): Observable<any> {
    return this._httpClient.post<any>(this.teamAPI, team);
  }

  getTeams():Observable<Team[]> {
    return this._httpClient.get<Team[]>(this.teamAPI);
  }

}
