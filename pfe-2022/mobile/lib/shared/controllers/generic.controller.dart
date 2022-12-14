import 'package:flutter/material.dart';
import 'package:get/get.dart';

class GenericController extends FullLifeCycleController
    with FullLifeCycleMixin {
  void initialization() {}

  @override
  void onDetached() {
    debugPrint('${(this).toString()} - onDetached called');
  }

  // Mandatory
  @override
  void onInactive() {
    debugPrint('${(this).toString()} - onInactive called');
  }

  // Mandatory
  @override
  void onPaused() {
    debugPrint('${(this).toString()} - onPaused called');
  }

  // Mandatory
  @override
  void onResumed() {
    onInit();
    debugPrint('${(this).toString()} - onResumed called');
  }

  @override
  void onClose() {
    // this.onInit();
    super.onClose();
  }
}
