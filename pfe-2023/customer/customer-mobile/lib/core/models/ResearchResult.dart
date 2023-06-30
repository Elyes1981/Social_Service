import 'dart:convert';

import 'package:customermobile/core/models/servicetypeModel.dart';




class researchModel {
  int? id;
  int? id_mou3ina;

  String? firstname_Mou3ina;
  String? lastname_Mou3ina;
  String? homeadress_Mou3ina;
  
 List<ServiceTypeModel> serviceTypes;  


  researchModel(
      {this.id,
      this.firstname_Mou3ina,
      this.id_mou3ina,
      this.lastname_Mou3ina,
      this.homeadress_Mou3ina,
        required this.serviceTypes,
      });

  factory researchModel.fromJson(Map<String, dynamic> json) => researchModel(
        id: json["id"],
        firstname_Mou3ina: json["firstname_Mou3ina"] ?? '',
        lastname_Mou3ina: json["lastname_Mou3ina"] ?? '',
        homeadress_Mou3ina: json["homeadress_Mou3ina"] ?? '',
        serviceTypes: List<ServiceTypeModel>.from(json["serviceTypes"].map((x) => ServiceTypeModel.fromJson(x))),

      );
  Map<String, dynamic> toJson() => {
        "id": id,
        "firstname_Mou3ina": firstname_Mou3ina,
        "lastname_Mou3ina": lastname_Mou3ina,
        "homeadress_Mou3ina": homeadress_Mou3ina,
      
        "serviceTypes": List<dynamic>.from(serviceTypes.map((x) => x.toJson())),
        
      };
}
