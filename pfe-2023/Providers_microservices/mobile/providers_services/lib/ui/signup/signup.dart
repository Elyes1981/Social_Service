
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'package:multiselect_formfield/multiselect_formfield.dart';
import 'package:providers_services/ui/SignUpViaCompany/ProviderCompanyRegistration.dart';
import 'package:providers_services/ui/login/login.ui.dart';
import 'package:providers_services/ui/signup/SignUp3.dart';
import 'package:providers_services/ui/signup/signupController.dart';
import 'package:select_form_field/select_form_field.dart';

class SignUp extends GetView<ServiceTypeController> {
  SignUp({Key? key}) : super(key: key);
  final formKey = new GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
          body: SingleChildScrollView(
            child: Column(
              //direction: Axis.vertical,
              children: [
                Column(
                  children: [
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
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.start,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: const [
                            SizedBox(
                              height: 2,
                            ),
                            Text(
                              "SignUp",
                            ),
                            SizedBox(
                              height: 25,
                            ),
                          ],
                        ),
                      ),
                    ),

                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: TextButton(
                            onPressed: () {
                              Navigator.push(
                              context,
                               MaterialPageRoute(
                               builder: (context) => LoginView(),
                                ),
                                 );
                             },
                            style: TextButton.styleFrom(
                              foregroundColor: Colors.blue ,
                                shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(16.0))
                            ),
                            /*child: Container(
                              color: Colors.blue,*/
                              //padding: const EdgeInsets.symmetric(vertical: 5, horizontal: 10),
                              child: const Text(
                                'Continue',
                                style: TextStyle(color: Colors.white, fontSize: 13.0,),
                              ),
                            ),
                        ),
                        SizedBox(
                          width: 140,
                        ),
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: TextButton(
                            onPressed: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute(
                                  builder: (context) => ProviderCompanyRegistration()//SignUp3(),
                                ),
                              );
                            },
                            style: TextButton.styleFrom(
                            foregroundColor: Colors.blue ,
                                shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(16.0))
                            ),
                              child: const Text(
                                'cancel',
                                style: TextStyle(color: Colors.white, fontSize: 13.0),
                              ),
                            ),
                        ),
                        ],
                    )
                  ],
                ),
              ],
            ),
          ),
    );
  }
}
