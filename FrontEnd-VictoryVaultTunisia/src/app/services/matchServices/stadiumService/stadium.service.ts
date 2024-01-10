import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stadium } from 'src/app/models/Stadium';

@Injectable({
  providedIn: 'root'
})
export class StadiumService {

  constructor(private _httpClient: HttpClient) {}
  stadiumsPI= `http://localhost:8082/stadiums`
  
  addStadiums(stadiums:Stadium): Observable<any> {
    return this._httpClient.post<any>(`${this.stadiumsPI}`, stadiums);
  }

  getStadiums():Observable<Stadium[]> {
    return this._httpClient.get<Stadium[]>(this.stadiumsPI);
  }

  uploadImage(formData:FormData): Observable<any> {
    return this._httpClient.post<any>(`${this.stadiumsPI}/uploadStadiumImage`, formData);
  }

  editStadium(stade:Stadium,stadeId:number){
    return this._httpClient.put<any>(`${this.stadiumsPI}/${stadeId}`, stade);
  }

  deleteStadium(stadeId:number){
    return this._httpClient.delete(`${this.stadiumsPI}/${stadeId}`)
  }

}
