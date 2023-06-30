import { Time } from '@angular/common';
import { ServiceType } from 'src/app/Model/service-type.module';
import { StatusReservation } from 'src/app/Model/status';
import { CustomerOrderMou3inaList} from 'src/app/Model/customer-order-mou3ina-list';
import { Recurrent } from 'src/app/Model/recurrent';
import { Customer } from './customer.model';
export interface Reservation {

    id: number;
    desiredDate:Date ;
    desiredHour:Date;
    gradeAverage:Number;
    numberOfMou3ina:Number;
    operationDate: Date;
    paymentStatus: string;
    morning:boolean;
    afternoon:boolean;
    evening:boolean;
    serviceTypes:ServiceType[];
    recurrent:boolean;
    Frequency : String;
    recurrents:Recurrent[];
   customerOrderMou3inaLists:CustomerOrderMou3inaList;
    frequency:string;
    customer:Customer;
    statuscode: StatusReservation;
    rate:number;
}
