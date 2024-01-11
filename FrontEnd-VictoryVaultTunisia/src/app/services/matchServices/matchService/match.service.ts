import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from 'src/app/models/Match';
import { Page } from 'src/app/models/Page';

@Injectable({
  providedIn: 'root'
})
export class MatchService {


  constructor(private _httpClient: HttpClient) {}
  matchAPI= `http://localhost:8082/matches`
  
  addMatch(match:Match): Observable<any> {
    return this._httpClient.post<any>(this.matchAPI, match);
  }

  getMatch():Observable<Page<Match>> {
    return this._httpClient.get<Page<Match>>(this.matchAPI);
  }}
