import { Component, OnInit,Inject } from '@angular/core';
import {MatDialogModule} from '@angular/material/dialog';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ReservationService } from "src/app/service/reservation.service";
import {Router} from "@angular/router";
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.scss']
})

export class DeleteModalComponent implements OnInit {
lang:any;
interval: any;
  constructor( private router: Router,@Inject(MAT_DIALOG_DATA) public data: any,private ReservationService: ReservationService,private Http:HttpClient) { }

  ngOnInit(): void {
   this.interval = setInterval(() => {
            this.lang=localStorage.getItem('lang');
          }, 1);
  console.log(this.data)

}
  deleteReservation(id: number) {
        this.ReservationService.delete(id)
          .subscribe(
            data => {
            console.log(data);

            },
        error => console.log(error));
         window.location.reload();
    }


  list(){
    this.router.navigate(['list']);
  }


    }
