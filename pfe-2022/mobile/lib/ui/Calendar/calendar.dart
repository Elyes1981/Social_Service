import 'dart:convert';

import 'package:date_picker_timeline/date_picker_timeline.dart';
import 'package:demo/core/models/Task.dart';
import 'package:demo/ui/Calendar/AddTaskPage.dart';
import 'package:demo/ui/Calendar/TaskLite.dart';
import 'package:demo/ui/Calendar/button.dart';
import 'package:demo/ui/Calendar/task_controller.dart';
import 'package:demo/ui/Calendar/theme.dart';
import 'package:demo/ui/login/login.ui.dart';
import 'package:demo/ui/profil/profil.dart';
import 'package:demo/ui/signup/signup.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_staggered_animations/flutter_staggered_animations.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:intl/intl.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:table_calendar/table_calendar.dart';


class Calendar extends StatefulWidget {
  const Calendar({ Key? key }) : super(key: key);

  @override
  State<Calendar> createState() => _CalendarState();
}

class _CalendarState extends State<Calendar> {
  DateTime _SelectedDate = DateTime.now();
  final _taskController =Get.put(TaskController());
  var notifyHelper;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
       
    body: Column(children: [
      Container(
        
        
        child: Row(
         
         children: [
          Container( 
           
            child: Column(
              
          // crossAxisAlignment: CrossAxisAlignment.end,
           children: [
            
            Text(DateFormat.yMMMMd().format(DateTime.now()),
            style: subHeadingStyle,),
            Text("20".tr , style: subHeadingStyle,),
            Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                     FloatingActionButton.extended(
        onPressed: ()async {
           await Get.to(()=>AddTaskPage());

             
           _taskController.getTasks();
          // Add your onPressed code here!
        },
        label: Text("21".tr,
        ),
        icon: const Icon(Icons.add),
        backgroundColor: Colors.grey,
      ),
              ],
            ),
        
          //  MyButton(label: "21".tr,
           //  onTap:() async{
          //   await Get.to(()=>AddTaskPage());

             
          // _taskController.getTasks();
          //   })

         ]), ) ,
           ],
       
      
       
      ),
        
         
     ),
       Container(
        margin: const EdgeInsets.only(top: 20,left: 20),
        child:DatePicker(
          DateTime.now(),
          height: 100,
          width:80,
          initialSelectedDate: DateTime.now(),
          selectionColor: primaryClr,
          selectedTextColor: Colors.white,
         
          dateTextStyle: TextStyle(
            fontSize: 20
            ,fontWeight: FontWeight.w600,
            color: Colors.grey
          ),
           onDateChange:(date){
            setState(() {
                _SelectedDate=date ;
            });
            
           } ,
        ),
       
      ),
      SizedBox(height: 10,),
      Expanded(child: Obx(() {
        return ListView.builder(
          itemCount: _taskController.taskList.length,
          itemBuilder: (_,index){
           
            Task task =_taskController.taskList[index];
            print(task.toJson());
            if(task.repeat=='Daily'){
               return AnimationConfiguration.staggeredList(
                position: index, 
                 child: SlideAnimation(child:FadeInAnimation(child:Row(
                  children: [
                    GestureDetector(
                      onTap: (){
                      _showBottomSheet(context, task);

                      },
                      child: TaskTile(task),
                    )
                  ],
                 ) ,)));


            }
             if(task.date==DateFormat.yMd().format(_SelectedDate)){
              return AnimationConfiguration.staggeredList(
                position: index, 
                 child: SlideAnimation(child:FadeInAnimation(child:Row(
                  children: [
                    GestureDetector(
                      onTap: (){
                      _showBottomSheet(context, task);

                      },
                      child: TaskTile(task),
                    )
                  ],
                 ) ,)));
             }
              else{
                return Container();
              }
            

          });
      }
      ))
     
        ],),   );
       
      
    
    
  }
 
}
_showBottomSheet(BuildContext context , Task task){
Get.bottomSheet(
  Container(
    padding: const EdgeInsets.only(top:4),
    height: task.isCompleted==1?
    MediaQuery.of(context).size.height*0.24:
    MediaQuery.of(context).size.height*0.32,
    child: Column(
      children: [
        Container(
          height:6,
          width: 120,
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(10),
            color: Colors.grey
          ),
        ),
        Spacer(),
        task.isCompleted==1
        ?Container()
        :
         
      
         
          _bottomSheetButton(
          label: "close", onTap: (){
            Get.back();
          }, clr: Colors.red[300]!,
          isClose: true,
          context: context
          )
      ],

    ),

  )
);
}
_bottomSheetButton({required String label,
required Function() onTap ,
required Color clr,
bool isClose= false,
 required BuildContext context
}){
  return GestureDetector(
    onTap: onTap,
    child: Container(
      margin: const EdgeInsets.symmetric(vertical: 4),
      height: 55,
      width: MediaQuery.of(context).size.width*0.9,
    
      decoration: BoxDecoration(
        border: Border.all(
          width: 2,
          color: isClose==true?Colors.grey[200]!:clr
        ),
        borderRadius: BorderRadius.circular(20),
          color: isClose==true?Colors.transparent:clr,
      ),
      child: Center(child: Text(
        label,
      )),
    ),
  );
}
     TextStyle get subHeadingStyle {
        return GoogleFonts.lato(
          textStyle: TextStyle(

            fontSize: 24,
            fontWeight: FontWeight.bold
          )
        );
       }
