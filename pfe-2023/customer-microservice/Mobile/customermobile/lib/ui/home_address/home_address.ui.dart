import 'package:country_state_city_pro/country_state_city_pro.dart';
/*import 'package:demo/shared/constants/button_widget.dart';
import 'package:demo/ui/ServicesType/servicestype.ui.dart';
import 'package:demo/ui/home_address/home_address.controller.dart';*/

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:introduction_screen/introduction_screen.dart';

import 'home_address.controller.dart';

class Home_address extends GetView<Home_addressController>{
  
  
  final minimumPadding = 50.0;
  int currentIndex = 0;
  TextEditingController country = TextEditingController();
  TextEditingController state = TextEditingController();
  TextEditingController city = TextEditingController();
  final TextEditingController _textController = new TextEditingController();
  void _handleSubmitted(String text) {
    _textController.clear();
  }

  void onTap(int index) {
    
      currentIndex = index;
  
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      /* appBar: AppBar(
        title: Text('Customer'),
        centerTitle: true , 
        backgroundColor: Color.fromARGB(255, 94, 7, 109),
      ),*/

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
                width: 400,
                height: 200,
                /* decoration: BoxDecoration(
                  color: Color.fromARGB(255, 246, 245, 248),
                  shape: BoxShape.rectangle,
                ),*/
                child: Image.asset(
                  'assets/images/c22.png',
                ),
              ),
              SizedBox(
                height: 24,
              ),
              Text(
                "Enter your OTP code number",
                style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.bold,
                  color: Colors.black38,
                ),
                textAlign: TextAlign.center,
              ),
              SizedBox(
                height: 24,
              ),
              Container(
                padding: EdgeInsets.all(28),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Column(
                  children: [
                    Column(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        CountryStateCityPicker(
                          country: country,
                          state: state,
                          city: city,
                        ),
                      ],
                    ),
                    SizedBox(
                      height: 16,
                    ),
                  ],
                ),
              ),
              SizedBox(
                height: 24,
              ),
              Text(
                "Please provide your exact location in next page",
                style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.bold,
                  color: Colors.black38,
                ),
                textAlign: TextAlign.center,
              ),
              SizedBox(
                height: 17,
              ),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () {
                    Navigator.of(context).pushNamed("maps");
                  },
                  style: ButtonStyle(
                    foregroundColor:
                        MaterialStateProperty.all<Color>(Colors.white),
                    backgroundColor: MaterialStateProperty.all<Color>(
                        Color.fromARGB(255, 59, 119, 189)),
                    shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                      RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(24.0),
                      ),
                    ),
                  ),
                  child: Padding(
                    padding: EdgeInsets.all(14.0),
                    child: Text(
                      'Next',
                      style: TextStyle(fontSize: 16),
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
