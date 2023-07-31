
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
const Color darkGreyClr =Color(0XFF121212);
const Color bluishClr =Color(0XFF4e5ae8);
const Color yellowClr =Color.fromARGB(255, 233, 217, 71);
const Color pinkClr =Color.fromARGB(255, 232, 78, 163);
Color darkHeaderClr =Color(0XFF121212);
Color primaryClr = bluishClr;
class Themes{
  static final Light =ThemeData(
    backgroundColor:Colors.white,
    primaryColor:Colors.white ,
    brightness: Brightness.light);

      static final dark =ThemeData(
    backgroundColor:darkGreyClr,
    primaryColor:darkGreyClr ,
    brightness: Brightness.dark);


   static TextStyle get subHeadingStyle {
        return GoogleFonts.lato(
          textStyle: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.bold
          )
        );
       }


       TextStyle get titleStyle {
        return GoogleFonts.lato(
          textStyle: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w400,
            
          )
        );
       }
  
   
}
