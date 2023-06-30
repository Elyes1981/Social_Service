import 'package:customermobile/core/models/servicetypeModel.dart';
import 'package:customermobile/core/models/statusResModel.dart';
import 'customerModel.dart';
import 'ordermou3inalist.dart';

class reservationModel {
  int? id;
 // int? numberOfMou3ina;
  //int? gradeAverage;
  //String? paymentStatus;
  DateTime? desiredDate;
  //DateTime? desiredHour;
  bool? morning;
  bool? afternoon;
  bool? evening;
  bool? isRecurrent;
 double? rate;
//List<CustomerOrderMou3InaList>? customerOrderMou3InaLists;
    List<ServiceTypeModel>? serviceTypes;
    //statusResModel ? statuscode;
   // customerModel? customer;

  reservationModel({
    this.id,
   // this.numberOfMou3ina,
    //this.gradeAverage,
 this.desiredDate,
   //  this.desiredHour,
   this.morning,
    //this.paymentStatus,
    this.afternoon,
    this.evening,
    this.isRecurrent,
     // this.statuscode,
 // this.customer,
this.rate,
    this.serviceTypes,
   //this.customerOrderMou3InaLists,
  
  });

  factory reservationModel.fromJson(Map<String, dynamic> json) =>
      reservationModel(
        id: json["id"],
         rate: json["rate"],
       // numberOfMou3ina: json["numberOfMou3ina"] ?? '',
      //  gradeAverage: json["gradeAverage"] ,
        desiredDate:json['desiredDate'] == null ? null : DateTime.parse(json['desiredDate'] as String),


        //desiredHour: DateTime.parse(json["desiredHour"]),
   morning: json["morning"] ?? '',
        evening: json["evening"] ?? '',
       
       afternoon: json["afternoon"] ?? '',
     isRecurrent: json["recurrent"] ?? '',
      //  paymentStatus: json["paymentStatus"] ?? '',

      //  customer: customerModel.fromJson(json["customer"]),
       // serviceTypes: ServiceTypeModel.fromJson(json["serviceTypes"]),
         serviceTypes: List<ServiceTypeModel>.from(json["serviceTypes"].map((x) => ServiceTypeModel.fromJson(x))),
       //customerOrderMou3InaLists: List<CustomerOrderMou3InaList>.from(json["customerOrderMou3inaLists"].map((x) => x)),
 //statuscode: statusResModel.fromJson(json["statuscode"]),
       
      );
  Map<String, dynamic> toJson() => {
        "id": id,
        //"numberOfMou3ina": numberOfMou3ina,
       // "gradeAverage": gradeAverage,
        "desiredDate": desiredDate!.toIso8601String(),
      //"desiredHour": desiredHour,
       "morning": morning,
        "evening": evening,
         "afternoon":afternoon,
        
         //"paymentStatus":paymentStatus,
       "isRecurrent": isRecurrent,
      // "statuscode": statuscode?.toJson(),
      //"customer":customer?.toJson(),
      "rate":rate,
"serviceTypes": List<dynamic>.from(serviceTypes!.map((x) => x.toJson())),
//"customerOrderMou3inaLists": List<CustomerOrderMou3InaList>.from(customerOrderMou3InaLists!.map((x) => x)),

      };
}
