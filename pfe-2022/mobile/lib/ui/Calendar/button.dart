import 'dart:convert';
import 'package:demo/ui/Calendar/theme.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/profil/profil.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:table_calendar/table_calendar.dart';

class MyButton extends StatelessWidget {
  final String label;
  final Function()? onTap;
  const MyButton({ Key? key ,required this.label,required this.onTap}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        
        width: 70,
        height: 60,
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(20),
          color: primaryClr
        ),
        child: Text(
          
          label,
          style: TextStyle(
            color: Colors.white,
          ),
        ),
      ),
      
    );
  }
}