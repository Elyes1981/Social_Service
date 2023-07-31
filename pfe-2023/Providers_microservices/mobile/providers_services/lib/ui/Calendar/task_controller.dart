import 'dart:ffi';
import'package:get/get.dart';
import 'package:providers_services/core/models/Task.dart';
import 'package:providers_services/core/services/AuthenticationService.dart';
import 'package:providers_services/core/services/TaskService.dart';
import 'package:providers_services/ui/DB/DBHelper.dart';
import 'package:providers_services/ui/login/AppPreferenceHelper%20.dart';
import 'package:providers_services/ui/profil/profilController.dart';

class TaskController extends GetxController{
    static TaskController instance = Get.find();
  TaskService taskService=Get.find();

    final AppPreferenceHelper _helper = new AppPreferenceHelper();
    final AuthenticationService _service =Get.put(AuthenticationService());
   late List tasks=[];
    late List<Task> tasksEmploye=[];
    String? name;

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
   print(profilController.instance.name);
      taskList.value = await taskService.find(name);
      
         }

  
  void delete(Task task){
    DBHelper.delete(task);
     getTasks();
  
  }


    @override
    void onInit() {
      super.onInit();

      name=_helper.userId.toString();
      getTasks();
    }
}