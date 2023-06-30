


/*import 'package:demo/shared/constants/Background.dart';
import 'package:demo/ui/home/home.ui.dart';
import 'package:demo/ui/login/Logingoogle.dart';
import 'package:demo/ui/login/login.controller.dart';
import 'package:demo/ui/register/register.ui.dart';*/
import 'dart:convert';

import 'package:flutter/material.dart';
//import 'package:google_sign_in/google_sign_in.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:http/http.dart' as http;
import 'package:get/get.dart';
import 'package:flutter_signin_button/flutter_signin_button.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../../shared/constants/Background.dart';
import '../local/local.controller.dart';
import '../notification/MessageScreen.dart';
import '../notification/notification.ui.dart';
import '../register/register.ui.dart';
import 'login.controller.dart';


class LoginView extends GetView<LoginController>{
 // const LoginView({Key? key}) : super(key: key);
String userEmail = "";
   TextEditingController usernameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    
    Size size = MediaQuery.of(context).size;

    return Scaffold(
     body: Background(child: Obx(() {
      return controller.isloading.isTrue
          ?
       
       Form(
                          key: _formKey,
child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              alignment: Alignment.centerLeft,
              padding: EdgeInsets.symmetric(horizontal: 40),
              child: Text(
                "Sign In",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Color(0xFF2661FA),
                  fontSize: 36
                ),
                textAlign: TextAlign.left,
              ),
            ),

            SizedBox(height: size.height * 0.03),

            Container(
              alignment: Alignment.center,
              margin: EdgeInsets.symmetric(horizontal: 40),
              child: TextField(
                controller: controller.usernameController,
                decoration: InputDecoration(
                  labelText: "Username"
                ),
              ),
            ),

            SizedBox(height: size.height * 0.03),

            Container(
              alignment: Alignment.center,
              margin: EdgeInsets.symmetric(horizontal: 40),
              child: TextField(
              controller: passwordController,
                decoration: InputDecoration(
                  labelText: "Password"
                ),
                obscureText: true,
              ),
            ),

           
            SizedBox(height: size.height * 0.05),

            Container(
              alignment: Alignment.centerRight,
              margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
              child: ElevatedButton (
                style: ElevatedButton.styleFrom(
                  // textColor: Colors.white,
                padding: const EdgeInsets.all(0),
                   shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(80.0)),
                ),
                onPressed:()  {
                  _formKey.currentState!.save();
   controller.onSubmit(_formKey.currentState!.validate());
   // Navigator.of(context).pushNamed("profile");
                  /*Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => NotificationView(),
                    ),
                  );*/
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => MessageScreen(),
                    ),
                  );
   
            },
               
               
                child: Container(
                  alignment: Alignment.center,
                  height: 50.0,
                  width: size.width * 0.5,
                  decoration: new BoxDecoration(
                    borderRadius: BorderRadius.circular(80.0),
                    gradient: new LinearGradient(
                      colors: [
                        Color.fromARGB(255, 20, 13, 88),
                        Color.fromARGB(255, 20, 13, 88),
                      ]
                    )
                  ),
                  padding: const EdgeInsets.all(0),
                  child: Text(
                    "Sign In",
                    textAlign: TextAlign.center,
                    style: TextStyle(
                      fontWeight: FontWeight.bold
                    ),
                  ),
                ),
              ),
             
            ),
             Container(/*
              alignment: Alignment.centerRight,
              margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
              child: GestureDetector(
                onTap: () => {
                  Navigator.push(context, MaterialPageRoute(builder: (context) => Register()))
                },
                child: Text(
                  "Don't Have an Account? Sign up",
                  style: TextStyle(
                    fontSize: 12,
                    fontWeight: FontWeight.bold,
                    color: Color(0xFF2661FA)
                    
                  ),
                ),
              ),*/
            ),
            Container(
              alignment: Alignment.centerRight,
              margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
              child: SignInButton(
            Buttons.Facebook,
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(16
                )),
            onPressed: ()  {
  
            },
          ),
             
            ),
            Container(
              alignment: Alignment.centerRight,
              margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
              child: SignInButton(
            Buttons.Google,
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(16
                )),
            onPressed: () async {
              await signInWithGoogle();Navigator.of(context).pushNamed("reshistory");}
              
              ,)
          
             
            ),
             

           
          ],
        ),
      ): Container(
              child: Center(child: CircularProgressIndicator()),
            );
  })
    ));
  }
Future<UserCredential> signInWithGoogle() async {
    // Trigger the authentication flow
    final GoogleSignInAccount? googleUser = await GoogleSignIn().signIn();

    // Obtain the auth details from the request
    final GoogleSignInAuthentication googleAuth = await googleUser!.authentication;

    // Create a new credential
    final credential = GoogleAuthProvider.credential(
      accessToken: googleAuth.accessToken,
      idToken: googleAuth.idToken,
    );

    userEmail = googleUser.email;

    // Once signed in, return the UserCredential
    return await FirebaseAuth.instance.signInWithCredential(credential);
  }
  void login() async{
    if (passwordController.text.isNotEmpty && usernameController.text.isNotEmpty){
 var response=await http.post(Uri.parse("http://10.0.2.2:8978/api/auth/signin"));
 body: ({"username":usernameController.text,
 "password":passwordController.text
 });
 if(response.statusCode==200){
   final body = jsonDecode(response.body);
      print("Login Token"+body["token"]);
pageRoute(body['token']);
 }
 else{
   print("Invalid Credentials");
 }

    }
    
  }  
  void pageRoute(String token)async{
    SharedPreferences sharedPreferences=await SharedPreferences.getInstance();
    await sharedPreferences.setString("login", token);
    Get.to(Register());
  }
}

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  Size get preferredSize => new Size.fromHeight(60);

  @override
  Widget build(BuildContext context) {
    MyLocaleController controllerLang =Get.find();
    return AppBar(


      backgroundColor: Colors.white.withOpacity(0),
      title: Text(""),
      actions: [
        PopupMenuButton(
            icon:Icon( Icons.language, ),
            color: Colors.white,
            elevation: 20,
            enabled: true,
            onSelected: (value){}    ,
            itemBuilder:(context) => [
              PopupMenuItem(
                child: Text("30".tr),
                onTap:(){controllerLang.changeLang('fr');},
                value: '',
              ),
              PopupMenuItem(
                child: Text("31".tr),
                onTap:(){controllerLang.changeLang('en');},

                value:'',
              ),
              PopupMenuItem(
                child: Text("32".tr),
                onTap:(){controllerLang.changeLang('ar');},
                value:'',
              ),
            ]
        )
      ],

    );
  }
}