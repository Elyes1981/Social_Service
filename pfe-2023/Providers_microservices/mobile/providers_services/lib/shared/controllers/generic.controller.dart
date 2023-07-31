import 'package:flutter/material.dart';
import 'package:get/get.dart';

class GenericController extends FullLifeCycleController
    //La classe définit diverses méthodes qui sont exécutées à différentes étapes du cycle de vie du contrôleur
    with FullLifeCycleMixin {  //fournit un ensemble de méthodes de cycle de vie qui sont appelées à différentes étapes du cycle de vie d'un widget.
  void initialization() {} //est appelée une fois lors de la première création du contrôleur.

  @override
  void onDetached() { //appelée lorsque le contrôleur est supprimé de l'arborescence des widgets.
    debugPrint('${(this).toString()} - onDetached called');
  }

  // Mandatory
  @override
  void onInactive() { //appelé lorsque le contrôleur n'est plus nécessaire et est dans un état inactif.
    debugPrint('${(this).toString()} - onInactive called');
  }

  // Mandatory
  @override
  void onPaused() { //lorsque le contrôleur est en pause, par exemple lorsque l'application est mise en arrière-plan.
    debugPrint('${(this).toString()} - onPaused called');
  }

  // Mandatory
  @override
  void onResumed() { //lorsque le contrôleur est repris, par exemple, lorsque l'application est ramenée au premier plan.
    onInit();
    debugPrint('${(this).toString()} - onResumed called');
  }

  @override
  void onClose() {
    // this.onInit();
    super.onClose();
  }
}
