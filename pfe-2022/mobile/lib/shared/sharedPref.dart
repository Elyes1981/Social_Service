import 'package:shared_preferences/shared_preferences.dart';

class SharedPref {
  static Future saveToken(
     String username, String emailAdress) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    
    sharedPreferences.setString("username", username);
    sharedPreferences.setString("emailAdress", emailAdress);
    
  
    print(sharedPreferences.getString("username"));
    print(sharedPreferences.getString("emailAdress"));
    
  }

  /*static Future<String> getToken() async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    var id = sharedPreferences.getString("id");
    return id;
  }*/

}