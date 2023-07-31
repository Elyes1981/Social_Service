import 'package:providers_services/core/models/Mou3inaModel.dart';
import 'package:providers_services/core/models/ServiceModel.dart';
import 'package:providers_services/core/models/customerModel.dart';

class notificationModel {
  int? id;
  String? title;
  String? body;
  //DateTime? createdAt;
  //String? token;
  //String? recipient;
  //Mou3inaEntity? provider ;


  notificationModel({
    this.id,
   this.title ,
    this.body,
    //this.createdAt,
    //this.token ,
    //this.recipient ,
    //this.provider

  });

  factory notificationModel.fromJson(Map<String, dynamic> json) =>
      notificationModel(
        id: json["id"],
        title: json["title"] ?? '',
        body: json["body"] ?? '',
        //createdAt: DateTime.parse(json["createdAt"]),
        //token: json["token"] ?? '',
        //recipient: json["recipient"] ?? '',
        //provider: Mou3inaEntity.fromJson(json["provider"]),


      );
  Map<String, dynamic> toJson() => {
    "id": id,
    //"createdAt": createdAt!.toIso8601String(),
    "title": title,
    "body": body,
    //"token":token,
    //"provider":provider?.toJson(),
    //"recipient":recipient,

  };
}
