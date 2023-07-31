import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Customer} from 'src/app/Model/customer.model';
import { ServiceType } from 'src/app/Model/service-type.module';
import { PreferencesMou3ina } from 'src/app/Model/preferences-mou3ina.model';
import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
import { CollaborationStatus } from 'src/app/Model/collaboration-status.model';
import { Gender } from "./gender";
export interface Mou3ina {
     id: number;
     firstName : String;
     lastName : String;
     home_Adress:String;
     phone:String  ;
     phone2:String  ;
     birthday:	Date;
     gender:Gender;
     emailAdress:String;
     comment:String;
     serviceType:ServiceType[];
     vip:String;
     video:String;
     inscriptionStatus:String;
     collaborationStatus:CollaborationStatus;
     mou3inaLists:CustomerResearchResultMou3inaList;
}
