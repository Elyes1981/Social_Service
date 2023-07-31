import 'package:providers_services/core/models/ServiceModel.dart';
import 'package:providers_services/core/models/customerModel.dart';

class reservationModel {
  int? id;
  // int? numberOfMou3ina;
  //DateTime? desiredDate;
  //DateTime? desiredHour;
  bool? morning;
  bool? afternoon;
  bool? evening;
  String? paymentStatus;
  // bool? isRecurrent;
  //double? rate;
  List<ServiceModel>? serviceTypes;
  customerModel? customer;
  String? status;

  reservationModel({
    this.id,
    // this.numberOfMou3ina,

    //this.desiredDate,
    //this.desiredHour,
    this.morning,
    this.afternoon,
    this.evening,
    this.paymentStatus,
    //this.rate,
    this.serviceTypes,

    //this.isRecurrent,
    // this.statuscode,
    this.customer,
    this.status,

    //this.customerOrderMou3InaLists,
  });

  factory reservationModel.fromJson(Map<String, dynamic> json) =>
      reservationModel(
        id: json["id"],
        //desiredDate: DateTime.parse(json["desiredDate"]),
        morning: json["morning"] ?? '',
        afternoon: json["afternoon"] ?? '',

        evening: json["evening"] ?? '',

        paymentStatus: json["paymentStatus"] ?? '',

        //rate: json["rate"],
        serviceTypes: List<ServiceModel>.from(
            json["serviceTypes"].map((x) => ServiceModel.fromJson(x))),

        // numberOfMou3ina: json["numberOfMou3ina"] ?? '',
        //gradeAverage: json["gradeAverage"] ,

        //desiredHour: DateTime.parse(json["desiredHour"]),

        //isRecurrent: json["isRecurrent"] ?? '',

        customer: customerModel.fromJson(json["customer"]),
        status: json["status"] ?? ''

        //serviceTypes: ServiceTypeModel.fromJson(json["serviceTypes"]),
        //customerOrderMou3InaLists: List<CustomerOrderMou3InaList>.from(json["customerOrderMou3inaLists"].map((x) => x)),
        //statuscode: statusResModel.fromJson(json["statuscode"]),
      );
  Map<String, dynamic> toJson() => {
        "id": id,
        //"numberOfMou3ina": numberOfMou3ina,
        //"gradeAverage": gradeAverage,
       // "desiredDate": desiredDate!.toIso8601String(),
        //"desiredHour": desiredHour,
        "morning": morning,
        "evening": evening,
        "afternoon": afternoon,
        "paymentStatus": paymentStatus,
        //"rate": rate,
        "serviceTypes":
            List<dynamic>.from(serviceTypes!.map((x) => x.toJson())),

        // "isRecurrent": isRecurrent,
        // "statuscode": statuscode?.toJson(),
        "customer": customer?.toJson(),
        "status": status,

        //"customerOrderMou3inaLists": List<CustomerOrderMou3InaList>.from(customerOrderMou3InaLists!.map((x) => x)),
      };
}
