
import 'package:demo/shared/constants/app_preferences.dart';
import 'package:get_storage/get_storage.dart';

class AppPreferenceHelper {
  // This class is not meant to be instantiated or extended; this constructor
  // prevents instantiation and extension.
  //AppPreferenceHelper._();

  // shared pref instance
  final GetStorage _store = GetStorage();

  // General Methods: ----------------------------------------------------------
  Future<String?> get authToken async {
    return _store.read(AppPreferences.auth_token);
  }

  Future<void> saveAuthToken(String authToken) async {
    return _store.write(AppPreferences.auth_token, authToken);
  }

  Future<void> removeAuthToken() async {
    return _store.remove(AppPreferences.auth_token);
  }

  String? get systemToken {
    return _store.read(AppPreferences.system_token);
  }

  Future<void> saveSystemToken(String sysToken) async {
    return _store.write(AppPreferences.system_token, sysToken);
  }

  Future<void> removeSystemToken() async {
    return _store.remove(AppPreferences.system_token);
  }

  // Login:---------------------------------------------------------------------
  Future<bool> get isLoggedIn async {
    return _store.read(AppPreferences.is_logged_in) ?? false;
  }

  Future<void> saveIsLoggedIn(bool value) async {
    return _store.write(AppPreferences.is_logged_in, value);
  }

  // Theme:------------------------------------------------------
  bool get isDarkMode {
    return _store.read(AppPreferences.is_dark_mode) ?? false;
  }

  Future<void> changeBrightnessToDark(bool value) {
    return _store.write(AppPreferences.is_dark_mode, value);
  }

  // Language:---------------------------------------------------
  String? get currentLanguage {
    return _store.read(AppPreferences.current_language);
  }

  Future<void> changeLanguage(String language) {
    return _store.write(AppPreferences.current_language, language);
  }






 

  Future<bool> get isPasswordExpired async {
    return _store.read(AppPreferences.is_password_expired) ?? false;
  }

  Future<void> saveIsPasswordExpired(bool value) async {
    return _store.write(AppPreferences.is_password_expired, value);
  }

  Future<void> saveUserID(String userId) async {
    return _store.write(AppPreferences.user_id, userId);
  }

  String? get userId {
    return _store.read(AppPreferences.user_id);
  }


  Future<void> saveUserEmail(String email) async {
    return _store.write(AppPreferences.email_adress, email);
  }

  String? get email {
    return _store.read(AppPreferences.email_adress);
  }
 Future<void> saveUserName(String username) async {
    return _store.write(AppPreferences.user_name, username);
  }

  String? get username {
    return _store.read(AppPreferences.user_name);
  }
 Future<void> saveUserFirst(String firstName) async {
    return _store.write(AppPreferences.first_name, firstName);
  }

  String? get firstName {
    return _store.read(AppPreferences.first_name);
  }



  Future<void> saveLanguage(String lang) {
    return _store.write(AppPreferences.lang, lang);
  }

  String? get language {
    return _store.read(AppPreferences.lang) ?? "";
  }




  Future<void> saveConfiguration(String key, String value) {
    return _store.write(key, value);
  }

 




  
}