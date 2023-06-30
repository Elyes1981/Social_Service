import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ServiceType } from 'src/app/Model/service-type.module';

@Injectable({
  providedIn: 'root'
})
export class ServiceTypeService {

private baseUrl = 'http://localhost:8978/ServiceTypes/';

     constructor(private http: HttpClient) { }

     get(id: number): Observable<any> {
       return this.http.get(this.baseUrl + `${id}`);
     }

     create(ServiceType: Object): Observable<Object> {
       return this.http.post(this.baseUrl , ServiceType);
     }

    
    
 
     delete(id: number): Observable<any> {
       return this.http.delete(this.baseUrl + `${id}`, { responseType: 'text' });
     }

     getList(): Observable<any> {
       return this.http.get(this.baseUrl);
}
}