class Task{
  int? id;
  String? title ;
  String? note ;
  int? isCompleted;
  String? date ;
  String? startTime ;
  String? endTime  ;
  int? color ;
  int? remind;
  String? repeat ;
 String? idMou3ina;
Task({
  this.id,
  this.idMou3ina,
  this.title,
  this.note,
  this.isCompleted,
  this.date,
  this.startTime,
  this.endTime,
  this.color,
  this.remind,
  this.repeat ,
});
 factory Task.fromJson(Map<String, dynamic> json) =>
      Task(
        id: json["id"],
      title: json["title"] ?? '',
        idMou3ina: json["idMou3ina"] ?? '',
        note: json["note"] ?? '',
          isCompleted: json["isCompleted"] ?? '',
           date: json["date"] ?? '',
           startTime: json["startTime"] ?? '',
            endTime: json["endTime"] ?? '',
            color: json["color"] ?? '',
             remind: json["remind"] ?? '',
              repeat: json["repeat"] ?? '',
        
        
      );
  Map<String, dynamic> toJson() =>
      {
        "id": id,
         "idMou3ina": idMou3ina,
        "title": title,
        "note": note,
         "date": date,
           "isCompleted": isCompleted,
              "startTime": startTime,
                 "endTime": endTime,
                  "color": color,
                   "remind": remind,
                    "repeat": repeat,
      
      
      };
}