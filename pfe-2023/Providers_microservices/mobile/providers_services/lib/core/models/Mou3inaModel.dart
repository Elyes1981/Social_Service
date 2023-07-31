import 'dart:ffi';

import 'package:flutter/services.dart';
import 'package:providers_services/core/models/DelegationModel.dart';
import 'package:providers_services/core/models/GenderModel.dart';
import 'package:providers_services/core/models/GouvernoratModel.dart';
import 'package:providers_services/core/models/LangageModel.dart';
import 'package:providers_services/core/models/ServiceModel.dart';
import 'package:providers_services/core/models/StatusModel.dart';
import 'package:providers_services/core/models/cooptedBy.dart';
import 'package:providers_services/core/models/seniorityModel.dart';


class Mou3inaEntity {

  Mou3inaEntity({
    this.id,
    this.firstName,
    this.lastName,
   this.gender,
    this.gouvernorat,
    this.deligation,
    this.phone,
    this.documentIdType,
    this.phone2,
    this.home_Adress,
    this.home_Adress_GPS_long,
    this.home_Adress_GPS_latt,
    this.collaborationStatus,
    this.inscriptionStatus,
     this.cooptedBy,
     this.video,
     this.emailAdress,
     this.vip,
     this.comment,
     this.langageSpeaking,
       this.rib,
        this.cooptedByID,
         this.gradeAverage,
         this.seniority,
         this.hasASmartPhone,
         this.photo,
         this.name,
         this.image,
          this.copie,
           this.operational_Id,
           this.status,
           this.serviceType,
            this.username,
             this.password,
             this.birthday,
             this.accessToken
            
  });

  int? id;
  String? firstName;
  String? lastName;
 // DateTime? Birthday;
  GenderModel? gender;
   GouvernoratModel? gouvernorat;
    DelegationModel? deligation;
  String? phone;
  String? documentIdType;
  String? phone2;
  String? home_Adress;
  double? home_Adress_GPS_long;
   double? home_Adress_GPS_latt;
   String? collaborationStatus ;
   String? inscriptionStatus ;
   CooptedByModel? cooptedBy;
   String? video ;
   String? emailAdress ;
   String? vip;
   String? accessToken;
   String? comment ;
  List<LangageModel>? langageSpeaking;
   dynamic rib ;
   int? cooptedByID ;
   int? gradeAverage ;
   SeniorityModel? seniority ;
   String? hasASmartPhone ;
   String? photo ;
  String? name;
   String? username;
    String? password;
     String? birthday;
  ByteData? image;
    ByteData? copie;
    int? operational_Id ;
    StatusModel? status ;
     List<ServiceModel>? serviceType;
   
    
    
 
 


  factory Mou3inaEntity.fromJson(Map<String, dynamic> json) =>
      Mou3inaEntity(
        id: json["id"],
        firstName: json["firstName"] ?? '',
        lastName: json["lastName"] ?? '',
        username: json["username"] ?? '',
        password: json["password"] ?? '',
         birthday: json["birthday"] ?? '',
        accessToken: json["accessToken"] ?? '',
        home_Adress_GPS_long:
            json["home_Adress_GPS_long"] != null ? json["home_Adress_GPS_long"].toDouble() : null,
        home_Adress_GPS_latt:
            json["home_Adress_GPS_latt"] != null ? json["home_Adress_GPS_latt"].toDouble() : null,
       
         gender: GenderModel.fromJson(json["gender"]),
         gouvernorat: GouvernoratModel.fromJson(json["gouvernorat"]),
          deligation: DelegationModel.fromJson(json["deligation"]),
       
       cooptedBy: CooptedByModel.fromJson(json["cooptedBy"]),
        phone: json["phone"] ?? '',
         phone2: json["phone2"] ?? '',
          documentIdType: json["documentIdType"] ?? '',
            home_Adress: json["home_Adress"] ?? '',
             collaborationStatus: json["collaborationStatus"] ?? '',
               inscriptionStatus: json["inscriptionStatus"] ?? '',
               
                 video: json["video"] ,
                  emailAdress: json["emailAdress"] ,
                      vip: json["vip"] ,
                       comment: json["comment"] ,
                         rib: json["rib"] ,
                          cooptedByID: json["cooptedByID"] ,
                          gradeAverage: json["gradeAverage"] ,
                           seniority: SeniorityModel.fromJson(json["seniority"]),
                           
                            hasASmartPhone: json["hasASmartPhone"] ,
                            photo: json["photo"] ,
                            name: json["name"] ,
                             image: json["image"] ,
                              copie: json["copie"] ,
                                 operational_Id: json["operational_Id"] ,
                                 
                                    status: StatusModel.fromJson(json["status"]),

      
             serviceType: json["serviceType"] != null
            ? List<ServiceModel>.from(json["serviceType"]
                .map((x) => ServiceModel.fromJson(x)))
            : <ServiceModel>[],


             langageSpeaking: json["langageSpeaking"] != null
            ? List<LangageModel>.from(json["langageSpeaking"]
                .map((x) => LangageModel.fromJson(x)))
            : <LangageModel>[],
      );

  Map<String, dynamic> toJson() =>
      {
        "id": id,
        "firstName": firstName,
        "lastName": lastName,
       "username": username,
       "password": password,
         "gender": gender?.toJson(),
       "gouvernorat": gouvernorat?.toJson(),
        "deligation": deligation?.toJson(),
      
        "documentIdType": documentIdType,
        "phone": phone,
        "phone2": phone2,
        "home_Adress": home_Adress,
        "home_Adress_GPS_long": home_Adress_GPS_long,
        "home_Adress_GPS_latt": home_Adress_GPS_latt,
           "collaborationStatus": collaborationStatus,
            "inscriptionStatus": inscriptionStatus,
             
               "cooptedBy": cooptedBy?.toJson(),
                "video": video,
               "birthday" :birthday,
                "emailAdress": emailAdress,
                "vip": vip,
                "comment": comment,
                 "rib": rib,
                   "cooptedByID": cooptedByID,
                     "gradeAverage": gradeAverage,
                     "seniority": seniority?.toJson(),
                    "accessToken" :accessToken,
                         "hasASmartPhone": hasASmartPhone,
                             "photo": photo,
                             "name": name,
                             "image": image,
                             "copie": copie,
                             "operational_Id": operational_Id,
                                
                             "status": status?.toJson(),
                            "serviceType": List<ServiceModel>.from(serviceType?.map((x) => x.toJson())??List.empty()),
                             "langageSpeaking": List<LangageModel>.from(langageSpeaking?.map((x) => x.toJson())??List.empty()),
                             
                             
                             
      };
}