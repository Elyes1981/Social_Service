export class StatusReservation {
    code: number;
    status_en:String;
    status_ar:String;
    status_fr:String;

    constructor(code_status: number,status_en:String,status_ar:String,status_fr:String) {
      this.code = code_status;
      this.status_en=status_en;
      this.status_ar=status_ar;
      this.status_fr=status_fr;
    }
}
