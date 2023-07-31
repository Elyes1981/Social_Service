import 'dart:convert';
import 'package:demo/core/models/Task.dart';
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
class TaskTile extends StatelessWidget {
 final Task? task ;

TaskTile(this.task);
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: 
      EdgeInsets.symmetric(horizontal: 20),
      width: MediaQuery.of(context).size.width,
      margin: EdgeInsets.only(bottom: 12),
      child: Container(padding:
      EdgeInsets.all(16),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(16),
        color: getBGClr(task?.color??0)
      ),
      child: Row(
        children: [
          Expanded(child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
         
           children: [
            Text(
              task?.title??"",
              style: GoogleFonts.lato(
                textStyle: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.white

                )
              ),
            ),
               Text(
              "${task!.date}",
              style: GoogleFonts.lato(
                textStyle: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.white

                )
              ),
            ),
            SizedBox(
              height: 12,
            ),
            Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Icon(Icons.access_time_rounded,
                color: Colors.grey[200],
                size: 18,),
                SizedBox(width: 4,),
                Text(
                  "${task!.startTime} -${task!.endTime}",
                  style: GoogleFonts.lato(
                    textStyle: TextStyle(fontSize: 13, color:Colors.grey[100]),

                  ),
                )

              ],
           
           
            ),
            SizedBox(height: 12,),
            Text(task?.note??"",
            style: GoogleFonts.lato(
              textStyle: TextStyle(fontSize: 15 ,color: Colors.grey)
            ),)
           ],
          )),
          Container(
            margin: EdgeInsets.symmetric(horizontal: 10),
            height: 60,
            width: 0.5,
            color: Colors.grey[200]!.withOpacity(0.7),
          ),
          RotatedBox(quarterTurns: 3,
          child: Text(
            task!.isCompleted==1? "COMPLETED ": "TODO" ,
            style: GoogleFonts.lato(
              textStyle: TextStyle(
                fontSize: 10,
                fontWeight: FontWeight.bold,
                color: Colors.white
              ),
            ),
          ),
          
          )
        ],
      ),
      ),



      
    );
  }
  getBGClr(int no){
    switch (no){
      case 0: return bluishClr ;
      case 1 : return pinkClr ;
      case 2 : return yellowClr;
      default: return bluishClr;
    }

  }
}