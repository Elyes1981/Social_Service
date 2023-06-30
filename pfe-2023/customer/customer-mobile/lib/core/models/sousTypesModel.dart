import 'dart:convert';

class sousTypesModel {
  int? idsous;
  
  String? label;
  String? label_fr;
  String? label_ar;

  sousTypesModel(
      {this.idsous, this.label, this.label_fr, this.label_ar});

  factory sousTypesModel.fromJson(Map<String, dynamic> json) =>
      sousTypesModel(
        idsous: json["idsous"],
        label: json["label"] ?? '',
        label_fr: json["label_fr"] ?? '',
        label_ar: json["label_ar"],
      
      );
  Map<String, dynamic> toJson() => {
        "idsous": idsous,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
       
      };
}
