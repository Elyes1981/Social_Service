import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const AUTH_API = 'http://localhost:8978/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'customers', {
      username,
      password
    }, httpOptions);
  }
  register(username: string, emailAdress: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username,
      emailAdress,
      password
    }, httpOptions);
  }
}
