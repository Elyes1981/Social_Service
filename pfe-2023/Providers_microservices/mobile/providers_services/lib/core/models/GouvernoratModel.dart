
import 'package:providers_services/core/models/DelegationModel.dart';

class GouvernoratModel {
  GouvernoratModel({
    this.idGouvert,
    this.name,
    this.name_ar,
    this.deligations,
  
  });

  int? idGouvert;

 List<DelegationModel>? deligations;
  String? name;
  String? name_ar;
 

  factory GouvernoratModel.fromJson(Map<String, dynamic> json) =>
      GouvernoratModel(
        idGouvert: json["idGouvert"],
        name: json["name"],
        name_ar: json["name_ar"],
         deligations: json["deligations"] != null
            ? List<DelegationModel>.from(json["deligations"]
                .map((x) => DelegationModel.fromJson(x)))
            : <DelegationModel>[],
      );
  Map<String, dynamic> toJson() =>
      {
        "idGouvert": idGouvert,
        "deligations": deligations,
        "name": name,
        "name_ar":name_ar
      };

}