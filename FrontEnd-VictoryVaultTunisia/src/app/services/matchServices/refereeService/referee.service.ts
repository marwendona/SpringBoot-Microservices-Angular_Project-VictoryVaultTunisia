import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Referee } from 'src/app/models/Referee';

@Injectable({
  providedIn: 'root'
})
export class RefereeService {

  constructor(private _httpClient: HttpClient) {}
  refereeAPI= `/matches-service/referees`

  addReferee(referee:Referee): Observable<any> {
    return this._httpClient.post<any>(this.refereeAPI, referee);
  }

  getReferee():Observable<Referee[]> {
    return this._httpClient.get<Referee[]>(this.refereeAPI);
  }

  editReferee(referee:Referee,refereeId:number){
    return this._httpClient.put<any>(`${this.refereeAPI}/${refereeId}`, referee);
  }

  deleteReferee(refereeId:number){
    return this._httpClient.delete(`${this.refereeAPI}/${refereeId}`)
  }
}
