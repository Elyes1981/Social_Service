/*import 'package:demo/core/models/complainTypeModel.dart';
import 'package:demo/core/models/customerModel.dart';
import 'package:demo/core/models/genderModel.dart';
import 'package:demo/core/models/sousTypesModel.dart';
import 'package:demo/core/models/statusModel.dart';*/

import 'package:customermobile/core/models/sousTypesModel.dart';

import 'complainTypeModel.dart';

class customercomplainModel {
  int? id;

  String? autre;

   DateTime? complainDate;

  //customerModel? customer;
  complainTypeModel? complainType;
  sousTypesModel? sousTypes;

  customercomplainModel(
      {this.id,
      this.autre,
      this.complainDate,
      //this.customer,
      this.complainType,
      this.sousTypes});

  factory customercomplainModel.fromJson(Map<String, dynamic> json) =>
      customercomplainModel(
        id: json["id"],
        autre: json["autre"],

        complainDate: DateTime.parse(json["complainDate"]),
        //customer: customerModel.fromJson(json["customer"]),
        complainType: json['complainType'] != null
            ? complainTypeModel.fromJson(json['complainType'])
            : null,
            sousTypes: json['sousTypes'] != null
            ? sousTypesModel.fromJson(json['sousTypes'])
            : null,
       // complainType: complainTypeModel.fromJson(json["complainType"]),
       // sousTypes: sousTypesModel.fromJson(json["complainType"]),
      );
  Map<String, dynamic> toJson() => {
        "id": id,
        "autre": autre,

         "complainDate": complainDate?.toIso8601String(),

        // "customer": customer?.toJson(),
        "complainType": complainType?.toJson(),
        "sousTypes": sousTypes?.toJson()
      };
}
