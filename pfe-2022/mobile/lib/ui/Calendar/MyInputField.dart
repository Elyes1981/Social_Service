import 'dart:convert';
import 'package:date_picker_timeline/date_picker_timeline.dart';
import 'package:demo/ui/Calendar/AddTaskPage.dart';
import 'package:demo/ui/Calendar/button.dart';
import 'package:demo/ui/Calendar/calendar.dart';
import 'package:demo/ui/Calendar/theme.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/profil/profil.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:intl/intl.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:table_calendar/table_calendar.dart';

class MyInputField extends StatelessWidget {
   final String title;
   final String hint;
   final TextEditingController? controller;
   final Widget? widget;
   const MyInputField({Key? key ,
   required this.title,   required this.hint,    this.controller,
     this.widget,
   }):super(key: key);

      TextStyle get titleStyle {
        return GoogleFonts.lato(
          textStyle: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w400,
            
          )
        );
       }




  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(top: 16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
        Text(title,style: Themes.subHeadingStyle),
        Container(
         height: 52,
         margin: EdgeInsets.only(top: 8.0),
         decoration: BoxDecoration(
          border: Border.all(
            color: Colors.grey,
            width: 1.0
          ),
          borderRadius: BorderRadius.circular(12)
         ),
         child: Row(
          children: [
            Expanded(child: TextFormField(
              readOnly: widget==null?false:true,
              autofocus: false,
              cursorColor: Colors.grey[700],
              controller: controller,
              style: titleStyle,
              decoration: InputDecoration(
                hintText: hint
              ),)
            ),
            widget== null?Container():Container(child: widget,)
          ],
         ),
        )
      ]),
      
    );
  }
}