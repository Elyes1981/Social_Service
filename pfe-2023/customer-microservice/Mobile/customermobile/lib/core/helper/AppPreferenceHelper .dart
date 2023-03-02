import 'dart:async';
//import 'package:demo/shared/constants/AppPreferences.dart';
import 'package:get_storage/get_storage.dart';

import '../../shared/constants/AppPreferences.dart';

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