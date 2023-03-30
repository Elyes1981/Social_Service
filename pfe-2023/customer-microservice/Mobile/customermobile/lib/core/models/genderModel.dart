import 'dart:convert';

class genderModel {
  int? id;
  
  String? label;
  String? label_fr;
  String? label_ar;

  genderModel(
      {this.id, this.label, this.label_fr, this.label_ar});

 /* factory genderModel.fromJson(Map<String, dynamic> json) =>
      genderModel(
        id: json["id"],
        label: json["label"] ,
        label_fr: json["label_fr"] ,
        label_ar: json["label_ar"],
      
      );*/
  factory genderModel.fromJson(Map<String, dynamic> json) =>
      genderModel(
        id: json["id"],
        label_fr: json["label_fr"] ?? '',
        label: json["label"] ?? '',
        label_ar: json["label_ar"],

      );
  Map<String, dynamic> toJson() => {
        "id": id,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
       
      };
}
