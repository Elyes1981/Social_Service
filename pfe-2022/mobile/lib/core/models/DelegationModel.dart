
import 'dart:ffi';

class DelegationModel {
  DelegationModel({
    this.idDeleg,
    this.name,
    this.name_ar,
    this.gPS_Latitude,
    this.gPS_Longtitude
  });

  int? idDeleg;
  Float? gPS_Latitude;
  Float?  gPS_Longtitude;
  String? name;
  String? name_ar;
 

  factory DelegationModel.fromJson(Map<String, dynamic> json) =>
      DelegationModel(
        idDeleg: json["idDeleg"],
        gPS_Latitude: json["gPS_Latitude"] ?? '',
        gPS_Longtitude: json["gPS_Longtitude"] ?? '',
        name: json["name"],
        name_ar: json["name_ar"],
      );
  Map<String, dynamic> toJson() =>
      {
        "idDeleg": idDeleg,
        "gPS_Latitude": gPS_Latitude,
        "gPS_Longtitude": gPS_Longtitude,
        "name": name,
        "name_ar":name_ar
      };

}