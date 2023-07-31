import 'package:demo/core/models/GenderModel.dart';
import 'package:demo/core/models/StatusModel.dart';
import 'package:demo/core/models/Task.dart';
import 'package:demo/core/services/generic.service.dart';
class TaskService  extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }
Future<List<Task>> findTask() async {
  List<Task> response = await apiCall(
    '/tasks',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => Task.fromJson(e)).toList(),
  );
  
  return Future.value(response);
}

Future<Task> create(Task task) async {
  return await apiCall(
    '/Task/newTask',
    isPost: true,
    body:task.toJson(),
  );
}
Future<Task> update(dynamic task) async {
  return await apiCall(
    '/Tasks/Task/id',
    isPost: true,
    body:task.toJson(),
  );
}
  find(String? idMou3ina) async {
    List<Task> response = await apiCall(
    '/Tasks/$idMou3ina',
    isPost: false,
    decoder: (json) =>
        (json as List<dynamic>).map((e) => Task.fromJson(e)).toList(),
  );
  return response;
  }
}