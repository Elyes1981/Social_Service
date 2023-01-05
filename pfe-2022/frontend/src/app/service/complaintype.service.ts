import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComplaintypeService {

  private baseUrl = `http://localhost:8978/complains`;

  constructor(private http: HttpClient) { }
  getcomplains(): Observable<any> {
    return this.http.get(`http://localhost:8978/complains`);}
}
