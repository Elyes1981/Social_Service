
class ReclamationModel {
  ReclamationModel({
    this.idReclamation,
    this.idMou3ina,
    this.message,
    this.status,
   
   
  });

  int? idReclamation;
   String?  idMou3ina;
  String? message;
  String? status;
  

  factory ReclamationModel.fromJson(Map<String, dynamic> json) =>
      ReclamationModel(
        idReclamation: json["idReclamation"],
         idMou3ina: json["idMou3ina"],
        message: json["message"] ?? '',
        status: json["status"] ?? '',
        
        
      );
  Map<String, dynamic> toJson() =>
      {
        "idReclamation": idReclamation,
         "idMou3ina": idMou3ina,
        "message": message,
        "status": status,
      
      
      };

}