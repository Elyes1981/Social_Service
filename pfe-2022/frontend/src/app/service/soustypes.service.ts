import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SoustypesService {

  private baseUrl = `http://localhost:8978/soustypes`;

  constructor(private http: HttpClient) { }
  getsoustypes(): Observable<any> {
    return this.http.get(`http://localhost:8978/soustypes`);}
}

