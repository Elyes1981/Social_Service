import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CooptedbytypeService {

  private baseUrl = `http://localhost:8978/cooptedbys`;

  constructor(private http: HttpClient) { }
  getcoopted(): Observable<any> {
    return this.http.get(`http://localhost:8978/cooptedbys`);}
}
