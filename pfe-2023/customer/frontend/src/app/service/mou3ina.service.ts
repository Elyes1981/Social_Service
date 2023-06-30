import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { ServiceType } from 'src/app/Model/service-type';

@Injectable({
  providedIn: 'root'
})
export class Mou3inaService {



  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private httpClient: HttpClient) {


   }

  create(mou3ina:Mou3ina): Observable<Mou3ina> {
    return this.httpClient.post<Mou3ina>(`http://localhost:8978/Mou3ina/newMou3ina`, JSON.stringify(mou3ina),
     this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
  createService(serviceType:ServiceType): Observable<ServiceType> {
    return this.httpClient.post<ServiceType>(``, JSON.stringify(serviceType),
     this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }



  getAll(): Observable<any> {
    return this.httpClient.get(`http://localhost:8978/Mou3inas`);

  }
  getALLCollaborationStatus(): Observable<any> {
   return this.httpClient.get(`http://localhost:8978/collaborationStatus`);
   }
  getAllService(): Observable<any> {
    return this.httpClient.get(`http://localhost:8978/ServiceTypes`);

  }
  delete(id:any){
    return this.httpClient.delete<Mou3ina>(`http://localhost:8978/deleteMou3inas/` + id, this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
  find(id:any) {
    return this.httpClient.get<Mou3ina>(`http://localhost:8978/Mou3ina/`+ id,this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  getMemberById(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8091/Mou3ina/' + id);

  }


  update(id:any, mou3ina:Mou3ina): Observable<Mou3ina> {
    return this.httpClient.put<Mou3ina>(`http://localhost:8978/Mou3inas/Mou3ina/` + id, JSON.stringify(mou3ina),
    this.httpOptions )
    .pipe(
      catchError(this.errorHandler)
    )
  }
  getCountries() {
		return this.httpClient.get(`assets/countries.json`);
	}
  errorHandler(error:any): Observable<never> {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
 }


}
