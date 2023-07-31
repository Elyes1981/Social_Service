import { HttpClient,HttpHeaders } from '@angular/common/http';
import { LocalizedString } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Agent } from '../Model/agent';


@Injectable({
  providedIn: 'root'
})
export class AgentService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }
  getagent(): Observable<any> {
    return this.http.get(`http://localhost:8978/agents`);

  }
  updateagent(id:number, agent:Agent): Observable<Agent> {
    return this.http.put<Agent>(`http://localhost:8978/agents/`+id, JSON.stringify(agent), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
