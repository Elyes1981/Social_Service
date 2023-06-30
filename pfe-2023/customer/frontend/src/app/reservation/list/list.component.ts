import { Component, OnInit, ViewChild } from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";

import { Reservation } from 'src/app/Model/reservation';
import { ServiceType } from 'src/app/Model/service-type.module';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ReservationService } from "src/app/service/reservation.service";
import {MatTableDataSource} from '@angular/material/table';
import {FormControl, Validators} from '@angular/forms';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { AddComponent } from 'src/app/reservation/add/add.component';
import { DeleteModalComponent } from 'src/app/reservation/delete-modal/delete-modal.component';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { DatePipe } from '@angular/common'
import {MatDialog} from '@angular/material/dialog';
import { Pipe, PipeTransform } from '@angular/core';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
const ELEMENT_DATA: Reservation[] = [ ];

 @Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

date=new Date();
d=new Date();
  lang:any;
  service!:string;
  currentUser: any;
  interval: any;
  ServiceTypeId!:ServiceType;
  reservations: Reservation[]=[];
  filterValues= [] as  any;
  filterSelectObj = [] as  any;
  reservation: Reservation;
 showAdminBoard = false;
  displayedColumns:string[] = ['DesiredDate','DesiredHour','NumberOfMou3ina',
  'Rate', 'OperationDate','PaymentStatus','ServiceTypeId','Status','star'];
  displayedColumnsar:string[] = ['star','DesiredDate','DesiredHour',
  'Rate','NumberOfMou3ina', 'OperationDate','PaymentStatus','Status','id'];
  dataSource!: MatTableDataSource<Reservation>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) matSort!: MatSort;
   constructor(private ReservationService: ReservationService,private Http:HttpClient,
    private router: Router,public dialog: MatDialog,private datePipe: DatePipe,private token: TokenStorageService) {

   this.ReservationService.getList().subscribe((data:Reservation[])=>{
         this.reservations=data;
         console.log(this.reservations)
         console.log(this.reservations[0].customer.id)

       })
      }
      ngAfterViewInit() {
        this.dataSource.paginator = this.paginator;
      }

    ngOnInit() {

      this.currentUser = this.token.getUser();
      this.ReservationService.getList().subscribe((data:Reservation[])=>{
        this.reservations=data;
        console.log(this.reservations)
        console.log(this.reservations[0].customer.id)

      })
      this.reloadData();
        this.interval = setInterval(() => {
          this.lang=localStorage.getItem('lang');
        }, 1);
     const datepipe:DatePipe =new DatePipe('en-US');
      this.dataSource = new MatTableDataSource<Reservation>(this.reservations)
      this.reloadData();

    }

    reloadData() {
      let resp = this.ReservationService.getbycustomer(this.currentUser.id);
      resp.subscribe(report =>this.dataSource.data = report as Reservation[])

      this.ReservationService.getbycustomer(this.currentUser.id).subscribe((data:Reservation[])=>{
        this.reservations=data;
        console.log(this.reservations)
      })
    }

  deletemodel(id1:number) {
   console.log(id1)
    this.dialog.open(DeleteModalComponent,{
      data: {
        id:id1 ,
      },
    });
  }



  applyFiltertime(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();
      }



    update(id: number){
        this.router.navigate(['updateCustomer', id]);
    }
    update1(id: number){
      this.router.navigate(['rating', id]);
  }
    detail(id: number){
      this.router.navigate(['detail', id]);
     }
     detail1(id: number){
      this.router.navigate(['pref_black', id]);
     }

     add() {
        this.router.navigate(['add']);
        
     /*
          this.dialog.open(AddComponent,{
            data: {
              animal: 'Add Reservation',
            },
          });
       */ }
       reclam() {
        this.router.navigate(['reclam']);}
        rating() {
          this.router.navigate(['rating']);}

    deleteReservation(id: number) {
        this.ReservationService.delete(id)
          .subscribe(
            data => {
            console.log(data);
            this.reloadData();
            },
        error => console.log(error));
    }


filterChange(filter:any, event: Event) {
          //let filterValues = {}
     const filterValue = (event.target as HTMLInputElement).value;
            // this.dataSource.filter = filterValue.trim().toLowerCase();
             this.dataSource.filter = filterValue;
        }


  applyFilter(date: Date) {
  console.log(this.datePipe.transform(date,'dd-MM-yyyy'))
       let resp =  this.ReservationService.getdate(this.datePipe.transform(date,'dd-MM-yyyy')|| '{}');
            resp.subscribe(report =>this.dataSource.data = report as Reservation[])

            this.ReservationService.getList().subscribe((data:Reservation[])=>{
              this.reservations=data;
              console.log(this.reservations)
            })
      }

  applyFilterservicetype(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
       console.log(filterValue)
       let resp =  this.ReservationService.getservicetype(filterValue || '{}');
            resp.subscribe(report =>this.dataSource.data = report as Reservation[])

            this.ReservationService.getList().subscribe((data:Reservation[])=>{
              this.reservations=data;
              console.log(this.reservations)
            })
      }

  applyFilterstatus(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
       console.log(filterValue)
       let resp =  this.ReservationService.getstatus(filterValue || '{}');
            resp.subscribe(report =>this.dataSource.data = report as Reservation[])

            this.ReservationService.getList().subscribe((data:Reservation[])=>{
              this.reservations=data;
              console.log(this.reservations)
            })
      }

  applyFilternbmo3ina(event: Event) {
   const filterValue = (event.target as HTMLInputElement).value;
              console.log(filterValue)
       let resp =  this.ReservationService.getnb(filterValue);
            resp.subscribe(report =>this.dataSource.data = report as Reservation[])

            this.ReservationService.getList().subscribe((data:Reservation[])=>{
              this.reservations=data;
              console.log(this.reservations)
            })
      }
       applyFiltergrade(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
                    console.log(filterValue)
             let resp =  this.ReservationService.getgrade(filterValue);
                  resp.subscribe(report =>this.dataSource.data = report as Reservation[])

                  this.ReservationService.getList().subscribe((data:Reservation[])=>{
                    this.reservations=data;
                    console.log(this.reservations)
                  })
            }


              refresh(): void {

          this.reloadData();
               }

               updateCustomer(id: number){
    
                this.router.navigate(['/update', id]);
                
              }
              

 }



