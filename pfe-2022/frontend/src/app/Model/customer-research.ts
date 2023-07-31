import { Time } from '@angular/common';
import { ServiceType } from 'src/app/Model/service-type.module';
import { Mou3ina } from 'src/app/Model/mou3ina';
import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
import { StatusReservation } from 'src/app/Model/status';
import { Recurrent } from 'src/app/Model/recurrent';
import { Customer } from 'src/app/Model/customer.model';
export interface CustomerResearch  {

    idResearch: number;
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
    statuscode: StatusReservation;
    recurrent:boolean;
    Frequency : String;
    recurrents:Recurrent[];
    mou3ina:Mou3ina[];
    re:CustomerResearchResultMou3inaList[];
    Customer:Customer[];

}
