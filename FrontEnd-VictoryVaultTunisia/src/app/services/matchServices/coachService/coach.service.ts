import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from 'src/app/models/Coach';

@Injectable({
  providedIn: 'root'
})
export class CoachService {

  constructor(private _httpClient: HttpClient) {}
  coachAPI= `http://localhost:8082/coach`
  
  addCoach(coach:Coach): Observable<any> {
    return this._httpClient.post<any>(this.coachAPI, coach);
  }

  getCoach():Observable<Coach[]> {
    return this._httpClient.get<Coach[]>(this.coachAPI);
  }
  getCoachById(id:number):Observable<Coach> {
    return this._httpClient.get<Coach>(`${this.coachAPI}/${id}`);
  }
}
