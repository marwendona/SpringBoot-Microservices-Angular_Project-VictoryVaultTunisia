import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from 'src/app/models/Page';
import { Stadium } from 'src/app/models/Stadium';

@Injectable({
  providedIn: 'root'
})
export class StadiumService {

  constructor(private _httpClient: HttpClient) {}
  stadiumsPI= `/matches-service/stadiums`

  addStadiums(stadiums:Stadium,file?:File): Observable<any> {
    let httpheader = new HttpHeaders();
        let options={
            headers: httpheader
        };
        const uploadData = new FormData();
        uploadData.append('name', stadiums.name);
        uploadData.append('capacity', stadiums.capacity.toString());

        if(file){
          uploadData.append('imageFile', file);
        }

    return this._httpClient.post<any>(`${this.stadiumsPI}`, uploadData,options);
  }

  getStadiums(page:number=0,size:number=10):Observable<Page<Stadium>> {
    let params = new HttpParams();
    params = params.set('size', size);
    params = params.set('page', page);
    return this._httpClient.get<Page<Stadium>>(this.stadiumsPI,{params});
  }


  editStadium(stade:Stadium,stadeId:number,file?:File){
    let httpheader = new HttpHeaders();
        let options={
            headers: httpheader
        };
        const uploadData = new FormData();
        uploadData.append('name', stade.name);
        uploadData.append('capacity', stade.capacity.toString());
        if(file){
          uploadData.append('imageFile', file);
        }
    return this._httpClient.post<any>(`${this.stadiumsPI}/${stadeId}`, uploadData,options);
  }

  deleteStadium(stadeId:number){
    return this._httpClient.delete(`${this.stadiumsPI}/${stadeId}`)
  }

}
