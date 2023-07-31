

import 'package:providers_services/core/models/Task.dart';
import 'package:providers_services/core/services/generic.service.dart';

class TaskService extends GenericService {
  @override
  void onInit() {
    super.onInit();
  }

//getListTask
  Future<List<Task>> findTask() async {
    List<Task> response = await apiCall(
      '/tasks',
      isPost: false,
      decoder: (json) =>
          (json as List<dynamic>).map((e) => Task.fromJson(e)).toList(),
    );

    return Future.value(response);
  }

//addTask
  Future<Task> create(Task task) async {
    return await apiCall(
      '/Task/newTask',
      isPost: true,
      body: task.toJson(),
    );
  }

//updateTask
  Future<Task> update(dynamic task) async {
    return await apiCall(
      '/Tasks/Task/id',
      isPost: true,
      body: task.toJson(),
    );
  }

//findTaskByidMou3ina
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
