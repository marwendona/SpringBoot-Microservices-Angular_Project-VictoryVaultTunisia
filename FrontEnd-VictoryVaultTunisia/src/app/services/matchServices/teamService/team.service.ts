import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Players } from 'src/app/models/Players';
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

  getPlayersByTeams(id:number):Observable<Players[]> {
    return this._httpClient.get<Players[]>(`${this.teamAPI}/${id}/players`);
  }

  deleteTeam(teamId:number){
    return this._httpClient.delete(`${this.teamAPI}/${teamId}`);
  }

  updateTeam(team:Team,teamId:number){
    return this._httpClient.put(`${this.teamAPI}/${teamId}`, team);
  }
}
