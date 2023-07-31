import 'dart:convert';

class statusModel {
  int? id;
  
  String? label;
  String? label_fr;
  String? label_ar;

  statusModel(
      {this.id, this.label, this.label_fr, this.label_ar});

  factory statusModel.fromJson(Map<String, dynamic> json) =>
      statusModel(
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
