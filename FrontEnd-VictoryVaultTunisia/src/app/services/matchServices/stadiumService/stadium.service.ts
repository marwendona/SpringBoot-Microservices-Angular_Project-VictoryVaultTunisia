import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stadium } from 'src/app/models/Stadium';

@Injectable({
  providedIn: 'root'
})
export class StadiumService {

  constructor(private _httpClient: HttpClient) {}
  stadiumsPI= `http://localhost:8082/stadiums`
  
  addStadiums(stadiums:Stadium,file:File): Observable<any> { 
    let params = new HttpParams();
    // params.set('name', stadiums.name);
    // params.set('capacity', stadiums.capacity);
    // params.set('imageFile', file);


    return this._httpClient.post<any>(`${this.stadiumsPI}`, {params});
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