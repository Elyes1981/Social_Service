import 'package:providers_services/core/models/reservationModel.dart';

class ProviderOrdersModel {
  int? id;
  DateTime? orderDay;
  int? rank;
  double? serviceCost;
  reservationModel? customerReservation ;

  ProviderOrdersModel({
    required this.id,
    required this.orderDay,
    required this.rank,
    required this.serviceCost,
    this.customerReservation,

  });

  factory ProviderOrdersModel.fromJson(Map<String, dynamic> json) =>
      ProviderOrdersModel(
          id: json["id"],
          orderDay: DateTime.parse(json["orderDay"]),
          rank: json["rank"],
          serviceCost: json["serviceCost"],
          customerReservation: reservationModel.fromJson(json["customerReservation"]),

      );

  Map<String, dynamic> toJson() =>
      {
        "id": id,
        "orderDay" : orderDay!.toIso8601String(),
        "rank" :  rank ,
        "serviceCost" : serviceCost ,
        "customerReservation": customerReservation?.toJson(),

      };
}