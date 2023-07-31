import { Agent } from './agent';
import { CustomerPreferences } from './customer-preferences.model';
import { Mou3ina } from './mou3ina';
export class Customer {

     id: number;
     firstName: string;
     lastName: string;
     //gender: Gender ;
    //s status: Status ;
     birthDate: Date;
     phone:string;
     cooptedByType:String;
     cooptedById: number;
    // gouvernerat: Gouvernorat[];
    mou3inas_preferences:   Mou3ina[];
    mou3inas_blacklist:   Mou3ina[];

     home_Adress:string;
     //delegation: Delegation[];
     photo:string;
     home_Adress_GPS_long: number;
     home_Adress_GPS_latt:number;
     emailAdress: string;
     paymentMean:string;
     creditCardNumber:number;
     //residenceType:Residencetype;
     creditCardCVV2:number;
     creditCardExpireDate:Date;
     residenceNumberOfrooms:number;
     numberOfPersonInRes:number;
     metrage: number;
     location:string;
     agent:Agent;
     preferences :CustomerPreferences;
     username:string;
     password:string;

  }
