import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_staggered_animations/flutter_staggered_animations.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:providers_services/ui/Calendar/task_controller.dart';
import 'package:providers_services/ui/Calendar/theme.dart';

class Tasks extends GetView<TaskController> {

  final navigatorKey = GlobalKey<NavigatorState>();
  DateTime _SelectedDate = DateTime.now();
  var notifyHelper;


  @override
  Widget build(BuildContext context) {
    controller.getTasks();
    print(controller.taskList.value);
    print("hiii" + controller.taskList.length.toString());

    return Expanded(

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
    }));
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
}
