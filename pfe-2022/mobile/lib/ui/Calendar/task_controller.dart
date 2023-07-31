import 'dart:ffi';

import 'package:demo/core/models/Task.dart';
import 'package:demo/core/services/TaskService.dart';
import 'package:demo/ui/DB/DBHelper.dart';
import 'package:demo/ui/profil/profilController.dart';
import'package:get/get.dart';
class TaskController extends GetxController{
    static TaskController instance = Get.find();
  TaskService taskService=Get.find();
   late List tasks=[];
    late List<Task> tasksEmploye=[];
  @override    
  void onReady(){
    super.onReady();
  }

RxList<Task> taskList = List<Task>.empty().obs;
 Future addTask({required Task task}) async{
    try {
     
      final Task response = await taskService.create(task);
    } catch (e) {
      print(e);
    
    }
  }
void markTskCompleted(int id ) async{
 await taskService.update(id);
 getTasks();
  }

 void getTasks() async{
      taskList.value = await taskService.find(profilController.instance.name);
      
         }

  
  void delete(Task task){
    DBHelper.delete(task);
     getTasks();
  
  }
}