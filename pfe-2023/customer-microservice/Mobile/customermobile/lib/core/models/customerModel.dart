


import 'package:customermobile/core/models/statusModel.dart';

import 'genderModel.dart';

class customerModel {
  int? id;

  String? Gendre;
  String? Status;
  String? firstName;
  String? lastName;
  String? username;
  String?password;
  String? phone;
  DateTime? birthDate;
  String? emailAdress;
  genderModel? gender;
  statusModel? status;
 // List<Mou3Ina> ?mou3inas_blacklist;
   // List<Mou3Ina>? mou3inas_preferences;


 // List<Mou3Ina>? mou3inas_preferences;

  customerModel(
      {this.id,
        this.Gendre,
        this.Status,
      this.firstName,
      this.username,
      this.password,
      this.lastName,
      this.phone,
      this.birthDate,
      this.emailAdress,
      this.gender,
      this.status,
     // this.mou3inas_blacklist,
     // this.mou3inas_preferences,
    //  this.mou3inas_preferences
      });

  factory customerModel.fromJson(Map<String, dynamic> json) => customerModel(
        id: json["id"],
    Gendre: json["Gendre"] ?? '',
    Status: json["Status"] ?? '',
        firstName: json["firstName"] ?? '',
     username: json["username"] ?? '',
        password: json["password"] ?? '',

        lastName: json["lastName"] ?? '',
        phone: json["phone"] ?? '',
        birthDate:  DateTime.parse(json["birthDate"]),
        emailAdress: json["emailAdress"] ?? '',
        gender: genderModel.fromJson(json["gender"]),
        status: statusModel.fromJson(json["status"]),
      // mou3inas_preferences: List<Mou3Ina>.from(json["mou3inas_preferences"].map((x) => Mou3Ina.fromJson(x))),
       // mou3inas_blacklist: List<Mou3Ina>.from(json["mou3inas_blacklist"].map((x) => Mou3Ina.fromJson(x))),

      );
  Map<String, dynamic> toJson() => {
        "id": id,
    "Gendre": Gendre,
    "Status": Status,
        "firstName": firstName,
    "username": username,
    "password":password,

        "lastName": lastName,
        "phone": phone,
        "birthDate": birthDate?.toIso8601String(),
        "emailAdress": emailAdress,
        "gender": gender?.toJson(),
        "status": status?.toJson(),
       // "mou3inas_preferences": List<Mou3Ina>.from(mou3inas_preferences!.map((x) => x.toJson())),
       // "mou3inas_blacklist": List<Mou3Ina>.from(mou3inas_blacklist!.map((x) => x.toJson())),

      };
}
