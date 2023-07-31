import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { CustomerOrderMou3inaList} from 'src/app/Model/customer-order-mou3ina-list';
import { Reservation } from 'src/app/Model/reservation';
@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
private baseUrl = 'http://localhost:8978/CustomerReservations/';

     constructor(private http: HttpClient) { }

     get(id: number): Observable<any> {
       return this.http.get(this.baseUrl + `${id}`);
     }
     getbycustomer(id: number): Observable<any> {
      return this.http.get('http://localhost:8978/CustomerReservations/customerReservations/' + `${id}`);
    }
    getbymou3ina(id: number): Observable<any> {
      return this.http.get('http://localhost:8978/CustomerReservations/customerReservations/mou3ina/' + `${id}`);
    }

     getdate(date: String): Observable<any> {
      return this.http.get(this.baseUrl + `date/`+`${date}`); }

    getservicetype(servicetype: String): Observable<any> {
      return this.http.get(this.baseUrl + `servicetype/`+`${servicetype}`); }

    getstatus(status: String): Observable<any> {
       return this.http.get(this.baseUrl + `status/`+`${status}`); }

    create(Reservation: Object): Observable<Object> {
      return this.http.post(this.baseUrl , Reservation);
    }

    addmou3ina(id:any,Reservation: Object): Observable<Object> {
       return this.http.post(this.baseUrl+`add/`+id, Reservation);
    }

    getnb(nb: String): Observable<any> {
       return this.http.get(this.baseUrl +`nb/`+`${nb}`);
    }

    getgrade(nb: String): Observable<any> {
        return this.http.get(this.baseUrl +`grade/`+`${nb}`);
    }

     update(id:any, reservation:Reservation): Observable<Reservation> {
      return this.http.put<Reservation>(`http://localhost:8978/CustomerReservations/` + id, JSON.stringify(reservation),
      this.httpOptions)

    }
    update1(id:any, reservation:Reservation): Observable<Reservation> {
      return this.http.put<Reservation>(`http://localhost:8978/CustomerReservations/` + id, JSON.stringify(reservation),
      this.httpOptions)

    }


     delete(id: number): Observable<any> {
       return this.http.delete(this.baseUrl + `${id}`, { responseType: 'text' });
     }
    getOrder(): Observable<any> {
       return this.http.get("http://localhost:8978/CustomerReservations/orders");
     }

     getList(): Observable<any> {
       return this.http.get("http://localhost:8978/CustomerReservations");
     }
}
