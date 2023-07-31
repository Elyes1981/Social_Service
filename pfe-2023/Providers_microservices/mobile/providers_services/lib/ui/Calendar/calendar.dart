import 'dart:convert';

import 'package:date_picker_timeline/date_picker_timeline.dart';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_staggered_animations/flutter_staggered_animations.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:intl/intl.dart';
import 'package:providers_services/core/models/Task.dart';
import 'package:providers_services/ui/Calendar/AddTaskPage.dart';
import 'package:providers_services/ui/Calendar/TaskLite.dart';
import 'package:providers_services/ui/Calendar/task_controller.dart';
import 'package:providers_services/ui/Calendar/theme.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:table_calendar/table_calendar.dart';


class Calendar extends GetView<TaskController> {
  final navigatorKey = GlobalKey<NavigatorState>();
  DateTime _SelectedDate = DateTime.now();
  var notifyHelper;


  @override
  Widget build(BuildContext context) {
    controller.getTasks();
    print(controller.taskList.value);
    print("hiii" + controller.taskList.length.toString());
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

             
           //controller.getTasks();
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

                _SelectedDate=date ;

            
           } ,
        ),
       
      ),
      SizedBox(height: 10,),
      Expanded(

          child: Obx(() {
            return ListView.builder(
                itemCount: controller.taskList.length,
                itemBuilder: (context, index) {
                  //Task task =controller.taskList[index];
                  //print(task.toJson());
                  //print( _taskController.taskList.length);
                  return AnimationConfiguration.staggeredList(
                      position: index,
                      child: SlideAnimation(
                          child: FadeInAnimation(
                              child: Row(children: [
                                GestureDetector(
                                    child: Container(
                                        padding: EdgeInsets.symmetric(horizontal: 20),
                                        width: MediaQuery.of(context).size.width,
                                        margin: EdgeInsets.only(bottom: 12),
                                        child: Container(
                                          padding: EdgeInsets.all(16),
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.circular(16),
                                              color: getBGClr(
                                                  controller.taskList[index].color ?? 0)),
                                          child: Row(
                                            children: [
                                              Expanded(
                                                  child: Column(
                                                      crossAxisAlignment: CrossAxisAlignment.start,
                                                      children: [
                                                        Text(controller.taskList[index].title!
                                                            .toString(),
                                                            style: GoogleFonts.lato(
                                                                textStyle: TextStyle(
                                                                    fontSize: 16,
                                                                    fontWeight: FontWeight.bold,
                                                                    color: Colors.white))),
                                                        Text(
                                                          controller.taskList[index].date!.toString(),
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
                                                              "${controller.taskList[index].startTime} -${controller.taskList[index].endTime}",
                                                              style: GoogleFonts.lato(
                                                                textStyle: TextStyle(fontSize: 13, color:Colors.grey[100]),

                                                              ),
                                                            ) ],


                                                        ),
                                                        SizedBox(height: 12,),
                                                        Text(controller.taskList[index].note!,
                                                          style: GoogleFonts.lato(
                                                              textStyle: TextStyle(fontSize: 15 ,color: Colors.grey)
                                                          ),)
                                                      ]
                                                  )),
                                              Container(
                                                margin: EdgeInsets.symmetric(horizontal: 10),
                                                height: 60,
                                                width: 0.5,
                                                color: Colors.grey[200]!.withOpacity(0.7),
                                              ),
                                              RotatedBox(quarterTurns: 3,
                                                child: Text(
                                                  controller.taskList[index].isCompleted==1? "COMPLETED ": "TODO" ,
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

                                        ))),
                              ]))));
                });
          }))
     
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

getBGClr(int no) {
  switch (no) {
    case 0:
      return bluishClr;
    case 1:
      return pinkClr;
    case 2:
      return yellowClr;
    default:
      return bluishClr;
  }
}
