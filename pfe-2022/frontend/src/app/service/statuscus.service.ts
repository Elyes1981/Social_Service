import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatuscusService {

  private baseUrl = `http://localhost:8978/statuss`;

  constructor(private http: HttpClient) { }
  getstatus(): Observable<any> {
    return this.http.get(`http://localhost:8978/statuss`);}
}
