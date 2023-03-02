import 'dart:convert';

class ResidenceTypeModel {
  int? id;
  
  String? label;
  String? label_fr;
  String? label_ar;

  ResidenceTypeModel(
      {this.id,  this.label, this.label_fr, this.label_ar});

  factory ResidenceTypeModel.fromJson(Map<String, dynamic> json) =>
      ResidenceTypeModel(
        id: json["id"],
        label: json["label"] ?? '',
        label_fr: json["label_fr"] ?? '',
        label_ar: json["label_ar"],
     
      );
  Map<String, dynamic> toJson() => {
        "id": id,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
       
      };
}
