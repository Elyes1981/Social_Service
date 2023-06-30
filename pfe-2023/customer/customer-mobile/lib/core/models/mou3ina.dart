class Mou3Ina {
   

    int? id;
    String? firstName;
   
    String? lastName;

     Mou3Ina({
         this.id,
     
     this.firstName,
        this.lastName,
        
    });
    

    factory Mou3Ina.fromJson(Map<String, dynamic> json) => Mou3Ina(
        id: json["id"],
        firstName: json["firstName"],
        lastName: json["lastName"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "firstName": firstName,
        "lastName": lastName,
      
    };
}