import { Mou3ina } from 'src/app/Model/mou3ina';
import{CustomerResearch} from 'src/app/Model/customer-research';
export class CustomerResearchResultMou3inaList {
 rank:number;
 postTagId:CustomerResearchResultMou3inaListId;
 mou3ina:Mou3ina;
 customerResearch:CustomerResearch
 }
export class CustomerResearchResultMou3inaListId{
id:Mou3ina;
idResearch:CustomerResearch;
}
