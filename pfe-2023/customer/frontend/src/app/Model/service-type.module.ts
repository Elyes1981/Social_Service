export class ServiceType { 

  idService: number;
  code:number ;
  label:String;
  label_ar:String;
  label_fr:String;

  constructor(idService: number,code:number,label:String,label_ar:String,label_fr:String) {
    this.idService = idService;
    this.code = code;
    this.label=label;
    this.label_ar=label_ar; 
    this.label_fr=label_fr;     
  }

}
