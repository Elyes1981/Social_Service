import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AgentService } from '../service/agent.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-rateagent',
  templateUrl: './rateagent.component.html',
  styleUrls: ['./rateagent.component.scss']
})
export class RateagentComponent implements OnInit {
  currentUser!:any;
  agentform!: FormGroup;
  id!:number;
  constructor(private token: TokenStorageService ,     private httpClient:HttpClient
    ,private agentService:AgentService,private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();

    this.agentform = new FormGroup({
      firstName: new FormControl(this.currentUser.agent.firstName,),
      lastname: new FormControl(this.currentUser.agent.lastname, ),
      email: new FormControl(this.currentUser.agent.email, ),
      rate: new FormControl('', ),
     
    })

  }
  
onSubmit(){
      console.log(this.agentform.value);
      this.agentService.updateagent(this.currentUser.agent.id, this.agentform.value).subscribe((res:any) => {
        console.log(this.agentform.value);

        console.log('Reservation updated successfully!');
          
      })
    }
    httpOptions:any
    onSend(email:String){
      this.httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        }),
        params:({'email':email})
      }
      this.httpClient.post('http://localhost:8978/sendemail',{},this.httpOptions).subscribe(data => {
        this.router.navigateByUrl('list');
      });
    }
}
