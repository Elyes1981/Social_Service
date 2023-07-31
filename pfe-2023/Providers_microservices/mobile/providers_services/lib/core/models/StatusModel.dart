
class StatusModel {
  StatusModel({
    this.id,
    this.label,
    this.label_fr,
    this.label_ar,
   
  });

  int? id;
  String? label;
  String? label_fr;
  String? label_ar;
  

  factory StatusModel.fromJson(Map<String, dynamic> json) =>
      StatusModel(
        id: json["id"],
        label_fr: json["label_fr"] ?? '',
        label: json["label"] ?? '',
        label_ar: json["label_ar"],
        
      );
  Map<String, dynamic> toJson() =>
      {
        "id": id,
        "label": label,
        "label_fr": label_fr,
        "label_ar": label_ar,
      
      };

}