import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResidencetypeService {
  private baseUrl = `http://localhost:8978/residenceTypes`;

  constructor(private http: HttpClient) { }
  getresidence(): Observable<any> {
    return this.http.get(`http://localhost:8978/residenceTypes`);}
}
