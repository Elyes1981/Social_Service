
class ServiceModel {
  ServiceModel({
    this.idService,
    this.label,
    this.label_fr,
    this.label_ar,
    this.code
  });

  int? idService;
  String? label;
  String? label_fr;
  String? label_ar;
  int? code;

  factory ServiceModel.fromJson(Map<String, dynamic> json) =>
      ServiceModel(
        idService: json["idService"],
        label: json["label"] ?? '',
        label_fr: json["label_fr"] ?? '',
        label_ar: json["label_ar"],
        code: json["code"],
      );
  Map<String, dynamic> toJson() =>
      {
        "idService": idService,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
        "code":code
      };

}