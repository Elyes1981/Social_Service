import 'dart:convert';

class ServiceTypeModel {
  int? idService;
  int? code;
  String? label;
  String? label_fr;
  String? label_ar;

  ServiceTypeModel(
      {this.idService, this.code, this.label, this.label_fr, this.label_ar});

  factory ServiceTypeModel.fromJson(Map<String, dynamic> json) =>
      ServiceTypeModel(
        idService: json["idService"],
        label: json["label"] ?? '',
        label_fr: json["label_fr"] ?? '',
        label_ar: json["label_ar"],
        code: json["code"],
      );
  Map<String, dynamic> toJson() => {
        "idService": idService,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
        "code": code
      };
}
