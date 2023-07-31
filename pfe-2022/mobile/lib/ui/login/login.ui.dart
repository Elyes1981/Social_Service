

import 'package:demo/core/models/Mou3inaModel.dart';
import 'package:demo/core/routes/app_routes.dart';
import 'package:demo/ui/Calendar/calendar.dart';

import 'package:demo/ui/login/MENU.dart';
import 'package:demo/ui/login/login.controller.dart';
import 'package:demo/ui/signup/map.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';

import 'package:google_sign_in/google_sign_in.dart';

class LoginView extends GetView<LoginController>{

   LoginView({Key? key}) : super(key: key);
      final GlobalKey<FormState> _formKeyy = GlobalKey<FormState>();
final FirebaseAuth _auth = FirebaseAuth.instance;
final GoogleSignIn _googleSignIn = GoogleSignIn();
String? mail ;
Future<UserCredential?> signInWithGoogle() async {
    // Trigger the authentication flow
    final GoogleSignInAccount? googleUser; 
    googleUser = await GoogleSignIn().signIn();
    final GoogleSignInAuthentication? googleAuth = await googleUser?.authentication;
    final credential = GoogleAuthProvider.credential(
      accessToken: googleAuth?.accessToken,
      idToken: googleAuth?.idToken,
    );
     
      mail=googleUser?.email;
 
    return await FirebaseAuth.instance.signInWithCredential(credential);
   
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
  
        body: SingleChildScrollView(
       child: Column( children: [
        Positioned(
            top: 0,
            child: Image.asset(
              'assets/2.jpg',
              width: 400,
              height: 150,
            )),
        Container(
          alignment: Alignment.center,
          child: Form(
           key: _formKeyy,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                 SizedBox(
                  height: 70,
                ),
               Text(
                "14".tr,
                style: GoogleFonts.pacifico(
                    fontWeight: FontWeight.bold,
                    fontSize: 50,
                    color: Colors.blue),
              ),
            
                Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: TextFormField(
                  controller: controller.usernameController,
                    validator: (value) {
                     
                    },
                    decoration: InputDecoration(
                      
                        icon: Icon(
                          Icons.account_circle,
                          color: Colors.blue,
                        ),
                        hintText: "15".tr,
                        enabledBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.blue)),
                        focusedBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.blue)),
                        errorBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.red)),
                        focusedErrorBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.red))),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: TextFormField(
                  
                   controller: controller.passwordController,
                    obscureText: true,
                    decoration: InputDecoration(
                        icon: Icon(
                          Icons.vpn_key,
                          color: Colors.blue,
                        ),
                        hintText: "16".tr,
                        enabledBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.blue)),
                        focusedBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.blue)),
                        errorBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.red)),
                        focusedErrorBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(16),
                            borderSide: BorderSide(color: Colors.red))),

                            
                  ),
                ),
                
                     
                Padding(
                padding: EdgeInsets.all(16),
                child: Container(
                  height: 50,
                  width: 400,
                  child: Center(
                    child: FlatButton(
                      height:50,
                      minWidth: 200,
                      color: Colors.blue,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(16.0),
                        side: BorderSide(color: Colors.grey),
                      ),

                      child: Padding(
                        padding: const EdgeInsets.fromLTRB(0, 10, 0, 10),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                           
                            Padding(
                              padding: const EdgeInsets.only(left: 10),
                              child: Text(
                                "14".tr,
                                style: TextStyle(
                                  fontSize: 20,
                                  color: Colors.white,
                                ),
                              ),
                            )
                          ],
                        ),
                      ),
                      onPressed: () {
                         controller.onSubmit(_formKeyy.currentState!.validate());
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => Categories(),
                          ),
                        );
                      },
                      // child: Text(
                      //   "Sign In with Google",
                      //   style: TextStyle(color: Colors.white, fontSize: 20),
                      // )
                    ),
                  ),
                ),
              ),
                    
                Padding(
                padding: EdgeInsets.all(16),
                child: Container(
                  height: 50,
                  width: 400,
                  child: Center(
                    child: FlatButton(
                      color: Colors.white,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(16.0),
                        side: BorderSide(color: Colors.grey),
                      ),

                      child: Padding(
                        padding: const EdgeInsets.fromLTRB(0, 10, 0, 10),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Image(
                                image: AssetImage("assets/google.png"),
                                height: 35.0),
                            Padding(
                              padding: const EdgeInsets.only(left: 10),
                              child: Text(
                                'Sign in with Google',
                                style: TextStyle(
                                  fontSize: 20,
                                  color: Colors.grey,
                                ),
                              ),
                            )
                          ],
                        ),
                      ),
                      onPressed: () {
                        signInWithGoogle();
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => Categories(),
                          ),
                        );
                      },
                      // child: Text(
                      //   "Sign In with Google",
                      //   style: TextStyle(color: Colors.white, fontSize: 20),
                      // )
                    ),
                  ),
                ),
              ),
                Padding(
                    padding: const EdgeInsets.fromLTRB(95, 20, 0, 0),
                    child: Row(
                      children: [
                        Text(
                          "18".tr,
                          style: TextStyle(
                              color: Colors.black, fontWeight: FontWeight.bold),
                        ),
                        InkWell(
                          onTap: () {
                           
                                   Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => localisatioMap(),
                  ),
                );
                          },
                          child: Text(
                            "19".tr,
                            style: TextStyle(
                                color: Colors.blue,
                                fontWeight: FontWeight.bold),
                          ),
                        ),
                      ],
                    ))
              ],
            ),
          ),
        )
      ],
    ),
    
       
    
        ),
   
    );
  }
}