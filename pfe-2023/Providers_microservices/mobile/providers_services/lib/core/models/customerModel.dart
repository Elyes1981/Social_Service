import 'package:providers_services/core/models/DelegationModel.dart';
import 'package:providers_services/core/models/GenderModel.dart';
import 'package:providers_services/core/models/GouvernoratModel.dart';
import 'package:providers_services/core/models/StatusModel.dart';
import 'package:providers_services/core/models/residencetypeModel.dart';

class customerModel {
  int? id;

  String? firstName;
  String? lastName;
  //String? username;
  //String?password;
  String? phone;
  //DateTime? birthDate;
  String? emailAdress;
  //GenderModel? gender;
  //StatusModel? status ;
  //GouvernoratModel? gouvernerat;
  //DelegationModel? delegation;
  String? home_Adress;
  double? home_Adress_GPS_long;
  double? home_Adress_GPS_latt;
  ResidenceTypeModel? residenceType;
  int? residenceNumberOfrooms ;
  int? numberOfPersonInRes;







  // List<Mou3Ina>? mou3inas_preferences;

  customerModel(
      {this.id,
        this.firstName,
        //this.username,
        //this.password,
        this.lastName,
        this.phone,
        //this.birthDate,
        this.emailAdress,
        //this.gender,
        //this.status,
        //this.gouvernerat,
        //this.delegation,
        this.home_Adress,
        this.home_Adress_GPS_long,
        this.home_Adress_GPS_latt,
        this.residenceType,
        this.residenceNumberOfrooms,
        this.numberOfPersonInRes,

        //  this.mou3inas_preferences
      });

  factory customerModel.fromJson(Map<String, dynamic> json) => customerModel(
    id: json["id"],
    firstName: json["firstName"] ?? '',
    //username: json["username"] ?? '',

    lastName: json["lastName"] ?? '',
    phone: json["phone"] ?? '',
    emailAdress: json["emailAdress"] ?? '',
    //gender: GenderModel.fromJson(json["gender"]),
    //status: StatusModel.fromJson(json["status"]),
    //gouvernerat: GouvernoratModel.fromJson(json["gouvernerat"]),
    //delegation: DelegationModel.fromJson(json["delegation"]),
    home_Adress: json["home_Adress"] ?? '',
    home_Adress_GPS_long: json["home_Adress_GPS_long"] != null ? json["home_Adress_GPS_long"].toDouble() : null,
    home_Adress_GPS_latt: json["home_Adress_GPS_latt"] != null ? json["home_Adress_GPS_latt"].toDouble() : null, //converti en nombre à virgule flottante (double)
    residenceType: ResidenceTypeModel.fromJson(json["residenceType"]),
    residenceNumberOfrooms: json["residenceNumberOfrooms"],
    numberOfPersonInRes: json["numberOfPersonInRes"],







  );
  Map<String, dynamic> toJson() => {
    "id": id,
    "firstName": firstName,
    //"username": username,
    //"password":password,

    "lastName": lastName,
    "phone": phone,
    //"birthDate": birthDate?.toIso8601String(),
    "emailAdress": emailAdress,
    //"gender": gender?.toJson(),
    //"status": status?.toJson(),
    //"gouvernerat": gouvernerat?.toJson(),
    //"deligation": delegation?.toJson(),
    "home_Adress": home_Adress,
    "home_Adress_GPS_long": home_Adress_GPS_long,
    "home_Adress_GPS_latt": home_Adress_GPS_latt,
    "residenceType" : residenceType?.toJson(),
    "residenceNumberOfrooms" : residenceNumberOfrooms,
    "numberOfPersonInRes" : numberOfPersonInRes,



  };
}
