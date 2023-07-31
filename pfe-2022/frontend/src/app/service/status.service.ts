import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { StatusReservation }      from 'src/app/Model/status';

@Injectable({
  providedIn: 'root'
})
export class StatusService {

private baseUrl = 'http://localhost:8978/statusReservation/';

     constructor(private http: HttpClient) { }

     get(code: number): Observable<any> {
       return this.http.get(this.baseUrl + `${code}`);
     }

     create(ServiceType: Object): Observable<Object> {
       return this.http.post(this.baseUrl , ServiceType);
     }

     delete(code: number): Observable<any> {
       return this.http.delete(this.baseUrl + `${code}`, { responseType: 'text' });
     }

     getList(): Observable<any> {
       return this.http.get(this.baseUrl);
}
}
