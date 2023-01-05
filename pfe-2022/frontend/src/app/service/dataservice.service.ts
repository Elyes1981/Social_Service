import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Reservation } from 'src/app/Model/reservation';
@Injectable({
  providedIn: 'root'
})
export class DataserviceService {
tab:  any[] = [];
a:any
 private nameSource = new BehaviorSubject<any[]>(this.tab);
  name = this.nameSource.asObservable()

  private idSource = new BehaviorSubject<any>(0);
    id = this.idSource.asObservable()
  constructor() { }
  changeName(name: any[],id:any) {
    this.nameSource.next(name);
    this.idSource.next(id);

  }
}
