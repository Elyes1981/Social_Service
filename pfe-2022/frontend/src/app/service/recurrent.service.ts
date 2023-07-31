import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Recurrent }      from 'src/app/Model/recurrent';
@Injectable({
  providedIn: 'root'
})
export class RecurrentService {


private baseUrl = 'http://localhost:8978/recurents';

     constructor(private http: HttpClient) { }

     get(idrecurrent: number): Observable<any> {
       return this.http.get(this.baseUrl + `${idrecurrent}`);
     }

     create(Recurrent: any): Observable<any> {
       return this.http.post(this.baseUrl , Recurrent);
     }

     delete(idrecurrent: number): Observable<any> {
       return this.http.delete(this.baseUrl + `${idrecurrent}`, { responseType: 'text' });
     }

     getList(): Observable<any> {
       return this.http.get(this.baseUrl);
}
}
