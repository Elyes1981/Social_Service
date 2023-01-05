
import 'package:demo/core/models/ServiceModel.dart';

class OrdesModel {
  OrdesModel({
    this.id,
    this.desiredDate,
    this.desiredHour,
    this.gradeAverage,
    this.numberOfMou3ina,
    this.operationDate,
    this.paymentStatus,
    this.morning,
    this.afternoon,
    this.evening,
    this.frequency,
    this.isRecurrent,
   this.serviceTypes,
   this.adress,
   this.telephone,
   this.nomClient,
  });

  
  int? id;

  DateTime? desiredDate;
   DateTime? desiredHour;
   int? gradeAverage ;
   int? numberOfMou3ina;
  DateTime? operationDate;
  String? paymentStatus ;
  bool? morning ; 
   bool? afternoon ; 
    bool? evening ; 
    int? frequency ;
    bool? isRecurrent ;
 List<ServiceModel>? serviceTypes;
  String? adress;
 String? telephone;
 String? nomClient;
  factory OrdesModel.fromJson(Map<String, dynamic> json) =>
      OrdesModel(
        id: json["id"],
       
          desiredDate:  DateTime.parse(json["desiredDate"]),
           desiredHour:  DateTime.parse(json["desiredHour"]),
       
        gradeAverage: json["gradeAverage"],
        numberOfMou3ina: json["numberOfMou3ina"],
      
          operationDate:  DateTime.parse(json["operationDate"]),
          paymentStatus: json["paymentStatus"],
           morning: json["morning"],
            afternoon: json["afternoon"],
             evening: json["evening"],
              frequency: json["frequency"],
               isRecurrent: json["isRecurrent"],
                adress: json["adress"],
                    telephone: json["telephone"],
                      nomClient: json["nomClient"],
    
                serviceTypes: json["serviceTypes"] != null
            ? List<ServiceModel>.from(json["serviceTypes"]
                .map((x) => ServiceModel.fromJson(x)))
            : <ServiceModel>[],
      );
  Map<String, dynamic> toJson() =>
      {
        "id": id,
           "desiredDate": desiredDate?.toIso8601String(),
        "desiredHour": desiredHour?.toIso8601String(),
      
        "gradeAverage": gradeAverage,
        "numberOfMou3ina":numberOfMou3ina,
         
          "operationDate": operationDate?.toIso8601String(),
            "paymentStatus": paymentStatus,
              "morning": morning,
                "afternoon": afternoon,
                  "evening": evening,
                    "frequency": frequency,
                      "isRecurrent": isRecurrent,
                       "adress": adress,
                        "telephone": telephone,
                         "nomClient": nomClient,
                      "serviceTypes": List<ServiceModel>.from(serviceTypes?.map((x) => x.toJson())??List.empty()), 

      };

}