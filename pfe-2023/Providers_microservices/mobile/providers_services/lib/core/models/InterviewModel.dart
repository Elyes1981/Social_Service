class interviewModel {
  int? id;
  DateTime? dateInterview;
  String? comment ;
  String? state;

  interviewModel(
  {this.id,
    this.dateInterview ,
    this.comment ,
    this.state,
  });
  factory interviewModel.fromJson(Map<String, dynamic> json) => interviewModel(
    id: json["id"],
    dateInterview: json["dateInterview"] ?? '',
    comment: json["comment"] ?? '',
    state: json["state"] ?? '',




  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "dateInterview" : dateInterview ,
    "comment" : comment,
    "state" : state,
  };
}