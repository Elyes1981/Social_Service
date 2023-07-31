import 'package:flutter/material.dart';

import 'dart:async';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:sms_autofill/sms_autofill.dart';

class MyHomePage extends StatefulWidget {
  // MyHomePage({Key key, this.title}) : super(key: key);

  // final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
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
      timeout: const Duration(seconds:20),
      verificationCompleted:
        (PhoneAuthCredential phoneAuthCredential) async {
      await _auth.signInWithCredential(phoneAuthCredential);
      showSnackbar(
          "Phone number automatically verified and user signed in: ${_auth.currentUser!.uid}");
    } ,
      verificationFailed:   (FirebaseAuthException authException) {
      showSnackbar(
          'Phone number verification failed. Code: ${authException.code}. Message: ${authException.message}');
    },
      codeSent: (String verificationId, int? resendToken) async {
      this._verificationId = verificationId;
      codeAutoRetrievalTimeout:    (String verificationId) {
      showSnackbar("verification code: " + verificationId);
      _verificationId = verificationId;
    };}, codeAutoRetrievalTimeout: (String verificationId) {  });
} catch (e) {
  showSnackbar("Failed to Verify Phone Number: ${e}");
}
    }
  void signInWithPhoneNumber() async {
  try {
    final AuthCredential credential = PhoneAuthProvider.credential(
      verificationId: _verificationId,
      smsCode: _smsController.text,
    );

    final User? user = (await _auth.signInWithCredential(credential)).user;

    showSnackbar("Successfully signed in UID: ${user?.uid}");
  } catch (e) {
    showSnackbar("Failed to sign in: " + e.toString());
  }
}
 

  void showSnackbar(String message) {
ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(message)));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        key: _scaffoldKey,
        //resizeToAvoidBottomPadding: false,
        body: Padding(
          padding: const EdgeInsets.all(8),
          child: Padding(
              padding: EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  TextFormField(
                    controller: _phoneNumberController,
                    decoration: const InputDecoration(
                        labelText: 'Phone number (+xx xxx-xxx-xxxx)'),
                  ),
                  Container(
                    padding: const EdgeInsets.symmetric(vertical: 16.0),
                    alignment: Alignment.center,
                    child: ElevatedButton (
                style: ElevatedButton.styleFrom(
                  shadowColor: Colors.greenAccent[700]),
                
                        child: Text("Get current number"),
                        onPressed: () async => {
                              _phoneNumberController.text =
                                  (await _autoFill.hint)!
                            },
                        
                    ), 
                  ),
                  Container(
                    padding: const EdgeInsets.symmetric(vertical: 16.0),
                    alignment: Alignment.center,
                    child: ElevatedButton (
                style: ElevatedButton.styleFrom( 
                  shadowColor: Colors.greenAccent[400]),
                     
                      child: Text("Verify Number"),
                      onPressed: () async {
                        fetchotp();
                      },
                    ),
                  ),
                  TextFormField(
                    controller: _smsController,
                    decoration:
                        const InputDecoration(labelText: 'Verification code'),
                  ),
                  Container(
                    padding: const EdgeInsets.only(top: 16.0),
                    alignment: Alignment.center,
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        shadowColor: Colors.greenAccent[200]),
                        onPressed: () async {
                          signInWithPhoneNumber();Navigator.of(context).pushNamed("home_address");

                        },
                        child: Text("Sign in")),
                  ),
                ],
              )),
        ));
  }
}
