import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerComplain } from '../Model/customerComplain';

@Injectable({
  providedIn: 'root'
})
export class CustomercomplainService {
  private baseUrl = `http://localhost:8978/customercomplains`;
 
  
  
  constructor(private http: HttpClient) { }

  getComplainList() {
    return this.http.get<CustomerComplain[]>(`http://localhost:8978/customercomplains`);
  }

  getCustomerComplain(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`)
    ;
    }
    getcomplainbycustomer(id: number): Observable<any> {
      return this.http.get('http://localhost:8978/customercomplains/customercomplain/' + `${id}`)
      ;
     
      }
    
    reloadCurrentPage() {
      window.location.reload();
     }
    
  createCustomerComplain(customercomplain: any): Observable<any> {
    return this.http.post(`http://localhost:8978/customercomplains`, customercomplain);}
}
