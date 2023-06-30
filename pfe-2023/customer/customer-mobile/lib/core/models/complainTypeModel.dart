import 'dart:convert';

import 'package:customermobile/core/models/sousTypesModel.dart';
//import 'package:demo/core/models/sousTypesModel.dart';

class complainTypeModel {
  int? id;
  
  String? label;
  String? label_fr;
  String? label_ar;
   List<sousTypesModel> sousTypes;

  complainTypeModel(
      {this.id, this.label, this.label_fr, this.label_ar,required this.sousTypes});

  factory complainTypeModel.fromJson(Map<String, dynamic> json) =>
      complainTypeModel(
        id: json["id"],
        label: json["label"] ?? '',
        label_fr: json["label_fr"] ?? '',
        label_ar: json["label_ar"],
        sousTypes: List<sousTypesModel>.from(json["sousTypes"].map((x) => sousTypesModel.fromJson(x))),
    
      
      );
  Map<String, dynamic> toJson() => {
        "id": id,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
        "sousTypes": List<dynamic>.from(sousTypes.map((x) => x.toJson())),
       
      };
}
