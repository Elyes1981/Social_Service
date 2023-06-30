import 'package:customermobile/core/models/reservationModel.dart';

import 'mou3ina.dart';

class CustomerOrderMou3InaList {
    

    Mou3Ina? mou3Ina;
    reservationModel? customerReservation;
    int? rank;
    DateTime? orderDay;

    CustomerOrderMou3InaList({
        this.mou3Ina,
        this.customerReservation,
        this.rank,
        this.orderDay,
    });

    factory CustomerOrderMou3InaList.fromJson(Map<String, dynamic> json) => CustomerOrderMou3InaList(
        mou3Ina: Mou3Ina.fromJson(json["mou3ina"]),
        customerReservation: reservationModel.fromJson(json["customerReservation"]),
        rank: json["rank"],
        orderDay: DateTime.parse(json["orderDay"]),
    );

    Map<String, dynamic> toJson() => {
        "mou3ina": mou3Ina!.toJson(),
        "customerReservation": customerReservation!.toJson(),
        "rank": rank,
        "orderDay": orderDay!.toIso8601String(),
    };
}