import { ComplainType } from "./complainType";
import { Customer } from "./customer.model";
import { SousTypes } from "./SousTypes";


export interface CustomerComplain {

    id: number;
    complainType:ComplainType;
    complainDate:Date;
    sousTypes:SousTypes;
    autre:String;
    customer:Customer


  }
