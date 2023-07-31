import { HttpClient,HttpHeaders } from '@angular/common/http';
import { LocalizedString } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { PreferencesMou3ina } from 'src/app/Model/preferences-mou3ina.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerPreferencesService {

   constructor(private http: HttpClient) { }
getAll (): Observable<any> {
    return this.http.get(`http://localhost:8978/Preferences`);

}
}
