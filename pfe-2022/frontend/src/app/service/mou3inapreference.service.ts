import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest } from '@angular/common/http';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})


export class Mou3inapreferenceService {
   constructor(private http: HttpClient) { }
getAll (): Observable<any> {
    return this.http.get(`http://localhost:8091/Preferencesmouiina`);


}
}
