import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CollaborationStatusService {


private baseUrl = 'http://localhost:8091/collaborationStatus';

     constructor(private http: HttpClient) { }

     get(id: number): Observable<any> {
       return this.http.get(this.baseUrl + `${id}`);
     }

     create(Recurrent: any): Observable<any> {
       return this.http.post(this.baseUrl , Recurrent);
     }

     delete(id: number): Observable<any> {
       return this.http.delete(this.baseUrl + `${id}`, { responseType: 'text' });
     }

     getList(): Observable<any> {
       return this.http.get(this.baseUrl);
}
}
