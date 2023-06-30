import 'dart:convert';

class preferencesModel {
  int? id_preference;
  
  double? rank;
  //customerModel ?customer;
 

  preferencesModel(
      {this.id_preference, this.rank,// this.customer
      });

  factory preferencesModel.fromJson(Map<String, dynamic> json) =>
      preferencesModel(
        id_preference: json["id_preference"],
        rank: json["rank"] ?? '',
     // customer: customerModel.fromJson(json["customer"])  ,  
      
      );
  Map<String, dynamic> toJson() => {
        "id_preference": id_preference,
        "rank": rank,
       //  "customer": customer?.toJson(),

        
       
      };
}
