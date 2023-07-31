import 'package:providers_services/core/models/Mou3inaModel.dart';

class CustomerOrderMou3inaList {
  CustomerOrderMou3inaList({
    required this.id,
    //required this.orderDay,
    required this.rank,
    required this.serviceCost,
    //this.mou3ina,
    //this.customerReservation,
  });

  int id;
  //DateTime orderDay;
  int rank;
  double serviceCost;
  //Mou3inaEntity? mou3ina ;

  factory CustomerOrderMou3inaList.fromJson(Map<String, dynamic> json) =>
      CustomerOrderMou3inaList(
        id: json["id"],
        //orderDay: DateTime.parse(json["OrderDay"]),
        rank: json["Rank"],
        serviceCost: json['serviceCost'].toDouble(),
      );

}
