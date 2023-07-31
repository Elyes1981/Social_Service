import { Component, OnInit, ElementRef ,ViewChild} from '@angular/core';
import { CustomerOrderMou3inaList} from 'src/app/Model/customer-order-mou3ina-list';
import { Reservation } from 'src/app/Model/reservation';
import {Router,ActivatedRoute} from "@angular/router";
import { ReservationService } from "src/app/service/reservation.service";
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})

export class DetailComponent implements OnInit {

@ViewChild('htmlData',{static:false}) htmlData!:ElementRef;

  id:any;
  reservations: Reservation[]=[];
 // customerOrderMou3inaLists:CustomerOrderMou3inaList[]=[];
  customerOrderMou3inaLists:CustomerOrderMou3inaList[]=[];
  customerOrderMou3inaList:CustomerOrderMou3inaList;
  reservation: Reservation;
   lang:any
   interval:any

  constructor(private ReservationService: ReservationService,private route: ActivatedRoute,
    private router: Router) { }
 reloadData(){
      this.ReservationService.getList().subscribe((data:Reservation[])=>{
            this.reservations=data;
            console.log(this.reservations)
      })
       this.ReservationService.getOrder().subscribe((data:CustomerOrderMou3inaList[])=>{
            this.customerOrderMou3inaLists=data;
            console.log(data)
          ;
              console.log(this.customerOrderMou3inaLists[0].mou3ina.id);
             /* if(this.reservation.id===this.customerOrderMou3inaList.customerReservation.id){
                console.log('helooooo')
              }*/
              
                                      });


 }


  ngOnInit() {
      this.reloadData();
               this.interval = setInterval(() => {
                 this.lang=localStorage.getItem('lang'|| 'en-US');
               }, 1);

    this.id = this.route.snapshot.params['id'];

    this.ReservationService.get(this.id)
      .subscribe(data => {
        this.reservation = data;
         console.log(this.reservation)
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['list']);
  }
  public openPDF(): void {
    let DATA: any = document.getElementById('htmlData');
    html2canvas(DATA).then((canvas) => {
      let fileWidth = 208;
      let fileHeight = (canvas.height * fileWidth) / canvas.width;
      const FILEURI = canvas.toDataURL('image/png');
      let PDF = new jsPDF('p', 'mm', 'a4');
      let position = 0;
      PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
      PDF.save('angular-demo.pdf');
    });
  }

 public downloadPDF():void {
 /*
             let data = this.htmlData.nativeElement;
             let options : any = {
             orientation: 'p',
             unit: 'px',
             format: 'a4',
             };
             let doc = new jsPDF(options);
             doc.html(data.innerHTML, {
             callback: function (doc) {
             doc.save("order-demo.pdf");
             },
              margin:10,
              x: 100,
              y: 100
              });
              }
*/
let DATA: any = document.getElementById('htmlData');
    html2canvas(DATA).then((canvas) => {
      let fileWidth = 200;
      let fileHeight = (canvas.height * fileWidth) / canvas.width;
    //  const FILEURI = canvas.toDataURL('image/png');
      let PDF = new jsPDF('p', 'mm', 'a4');
      let position = 0;
     // PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
      PDF.save('order_details.pdf');
    });
  }
}
