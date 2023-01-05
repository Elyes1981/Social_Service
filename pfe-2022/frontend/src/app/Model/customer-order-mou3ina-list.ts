import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { Reservation } from 'src/app/Model/reservation';

export class CustomerOrderMou3inaList {

 rank:number;
 primaryKey:CustomerOrderMou3inaListId;
 orderDay:Date;
 mou3ina:Mou3ina;
 customerReservation:Reservation
 }

export class CustomerOrderMou3inaListId{
 mou3ina:Mou3ina;
 customerReservation:Reservation
}
