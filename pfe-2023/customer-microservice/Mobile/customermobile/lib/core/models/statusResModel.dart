import 'dart:convert';

class statusResModel {
  int? code;
  
  String? status_en;
  String? status_fr;
  String? status_ar;

  statusResModel(
      {this.code, this.status_en, this.status_fr, this.status_ar});

  factory statusResModel.fromJson(Map<String, dynamic> json) =>
      statusResModel(
        code: json["code"],
        status_en: json["status_en"] ?? '',
        status_fr: json["status_fr"] ?? '',
        status_ar: json["status_ar"],
      
      );
  Map<String, dynamic> toJson() => {
        "code": code,
        "status_en": status_en,
        "status_fr": status_fr,
        "status_ar": status_ar,
       
      };
}
