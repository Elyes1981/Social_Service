import { HttpClient,HttpHeaders } from '@angular/common/http';
import { LocalizedString } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Customer } from 'src/app/Model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
index!:any
  private baseUrl = `http://localhost:8978/customers`;
  home_Adress_GPS_latt!:number;
  home_Adress_GPS_long!:number;
  public customers: Customer[] = [];

  constructor(private http: HttpClient) { }


  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
    }

    reloadCurrentPage() {
      window.location.reload();
     }

  createCustomer(customer: any): Observable<any> {
    return this.http.post(`http://localhost:8978/customers`, customer);}


    getdelegation(idgouv:number): Observable<any> {
    return this.http.get(`http://localhost:8978/delegations/${idgouv}`);}

     getgouvernorat(): Observable<any> {
      return this.http.get(`http://localhost:8978/gouvernorats`);}
      get_latt(){
        return localStorage.getItem('home_Adress_GPS_latt');
      }
      get_long(){

        return localStorage.getItem('home_Adress_GPS_long');
      }


  updateCustomer(id:number, customer:Customer): Observable<Customer> {
    return this.http.put<Customer>(`http://localhost:8978/customers/`+id, JSON.stringify(customer), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }


  deleteCustomer(id: number) {
    return this.http.delete(`http://localhost:8978/customers/`+id, { responseType: 'text' });


  }
getCountries() {
    return this.http.get(`assets/countries.json`);
  }

  getCustomersList() {
    return this.http.get<Customer[]>(`http://localhost:8978/customers`);
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

  create(customer: any): Observable<any> {
      return this.http.post<Customer>(`http://localhost:8978/customers`, JSON.stringify(customer),
       this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )

}
}
