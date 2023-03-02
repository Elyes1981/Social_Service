


//import 'dart:js';

//import 'package:demo/ui/sms/sms.controller.dart';
import 'package:customermobile/ui/sms/sms.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'package:intl_phone_field/intl_phone_field.dart';
import 'dart:async';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:sms_autofill/sms_autofill.dart';


class Registerphone extends GetView<SmsController> {
  
   final _scaffoldKey = GlobalKey<ScaffoldState>();
  final FirebaseAuth _auth = FirebaseAuth.instance;
  
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _smsController = TextEditingController();
  late String _verificationId;
  final SmsAutoFill _autoFill = SmsAutoFill();
    Future<void> fetchotp() async {
      try {
  await _auth.verifyPhoneNumber(
    
      phoneNumber: _phoneNumberController.text,
      timeout: const Duration(seconds: 30),
      verificationCompleted:
        (PhoneAuthCredential phoneAuthCredential) async {
      await _auth.signInWithCredential(phoneAuthCredential);
      /*showSnackbar(
          "Phone number automatically verified and user signed in: ${_auth.currentUser!.uid}");*/
    } ,
      verificationFailed:   (FirebaseAuthException authException) {
    /*  showSnackbar(
          'Phone number verification failed. Code: ${authException.code}. Message: ${authException.message}');
    */},
      codeSent: (String verificationId, int? resendToken) async {
      this._verificationId = verificationId;
      codeAutoRetrievalTimeout:    (String verificationId) {
     // showSnackbar("verification code: " + verificationId);
      _verificationId = verificationId;
    };}, codeAutoRetrievalTimeout: (String verificationId) {  });
} catch (e) {
 // showSnackbar("Failed to Verify Phone Number: ${e}");
}
    }
 
 

 /* void showSnackbar(String message) {
    // modifier
    ScaffoldMessenger.of(context as BuildContext ).showSnackBar(SnackBar(content: Text(message)));
  }
  */

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: Color(0xfff7f6fb),
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.symmetric(vertical: 24, horizontal: 32),
          child: Column(
            children: [
              Align(
                alignment: Alignment.topLeft,
                child: GestureDetector(
                  onTap: () => Navigator.pop(context),
                  child: Icon(
                    Icons.arrow_back,
                    size: 32,
                    color: Colors.black54,
                  ),
                ),
              ),
              SizedBox(
                height: 18,
              ),
              Container(
                width: 200,
                height: 200,
                decoration: BoxDecoration(
                  color: Colors.deepPurple.shade50,
                  shape: BoxShape.circle,
                ),
                child: Image.asset(
                  'assets/images/illustration-2.png',
                ),
              ),
              SizedBox(
                height: 24,
              ),
              Text(
                'Registration',
                style: TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                ),
              ),
              SizedBox(
                height: 10,
              ),
              Text(
                "Add your phone number. we'll send you a verification code so we know you're real",
                style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.bold,
                  color: Colors.black38,
                ),
                textAlign: TextAlign.center,
              ),
              SizedBox(
                height: 28,
              ),
              Container(
                padding: EdgeInsets.all(28),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Column(
                  children: [
                    TextFormField(
                    controller: _phoneNumberController,
                    decoration: const InputDecoration(
                        labelText: 'Phone number (+xx xxx-xxx-xxxx)'),
                  ),
                    SizedBox(
                      height: 22,
                    ),
                    SizedBox(
                      width: double.infinity,
                      child: ElevatedButton(
                       /* onPressed: () {
                          Navigator.of(context).push(
                            MaterialPageRoute(builder: (context) => Sms()),
                          );
                        },*/
                        onPressed: () async {
                        fetchotp();
                        Navigator.of(context).pushNamed("Sms");

                      },
                        style: ButtonStyle(
                          foregroundColor:
                              MaterialStateProperty.all<Color>(Colors.white),
                          backgroundColor:
                              MaterialStateProperty.all<Color>(Colors.purple),
                          shape:
                              MaterialStateProperty.all<RoundedRectangleBorder>(
                            RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(24.0),
                            ),
                          ),
                        ),
                        child: Padding(
                          padding: EdgeInsets.all(14.0),
                          child: Text(
                            'Send',
                            style: TextStyle(fontSize: 16),
                          ),
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
