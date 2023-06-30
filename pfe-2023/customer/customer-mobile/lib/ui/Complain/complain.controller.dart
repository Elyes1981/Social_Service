import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

import '../../core/models/complainTypeModel.dart';
import '../../core/models/customercomplainModel.dart';
import '../../core/models/sousTypesModel.dart';
import '../../core/routes/app_routes.dart';
import '../../core/services/complainType.service.dart';
import '../../core/services/cus_complain.service.dart';
import '../../core/services/sousTypes.service.dart';
import '../../shared/controllers/generic.controller.dart';

class ComplainController extends GenericController {
  static ComplainController instance = Get.find();
  SousTypesService sousTypesService = Get.find();
  CusComplainService cusComplainService = Get.find();

  ComplainTypeService complainTypeService = Get.find();

  late RxList<dynamic> cmplist = List<dynamic>.empty().obs;
  RxList<customercomplainModel> cus_cmpList = List<customercomplainModel>.empty().obs;

  List<sousTypesModel> souslist = [];
  late List<Map<String, dynamic>> sousTypesList = [];
  List<complainTypeModel> complist = [];
  late List<Map<String, dynamic>> complainList = [];
  String? sousSelected;
  //complainTypeModel compSelected=complainTypeModel(sousTypes: []);
  String? compSelected;
  RxBool isloading = true.obs;

  RxBool isSelected = true.obs;

  late TextEditingController autre;
  late customercomplainModel cuscomplain;

  @override
  void onInit() {
    findcomp();
    // findsoustypes();
    // findcomptype();
    // findResearch();
    // rank = new TextEditingController();
    autre = TextEditingController();

    super.onInit();
  }

  void initialization() async {
    autre = TextEditingController();

    super.initialization();
  }

  Future<void> createCustComplain() async {
    try {
      final customercomplainModel response =
          await cusComplainService.createcomplain(cuscomplain);

      Get.offAndToNamed(AppRoutes.reshistory);

      initialization();
    } catch (e) {
      print(e);
    }
  }

  addcuscomplain(bool isvalid) async {
    if (isvalid) {
      cuscomplain = customercomplainModel();

      complainTypeModel cmp = complist
          .firstWhere((element) => element.id.toString() == compSelected);
      sousTypesModel st = souslist
          .firstWhere((element) => element.idsous.toString() == sousSelected);
      cuscomplain.autre = autre.text;
      cuscomplain.complainType = cmp;
      cuscomplain.sousTypes = st;

      await createCustComplain();
      print("added successfuly");
    } else {
      print("Error");
    }
  }

  selectComplain(comp) {
    compSelected = comp;
  }

  findcomptype() async {
    isloading(true);
    complist = await complainTypeService.findcomplainType();
    complainList = [
      {
        'value': complist[0].id,
        'label': complist[0].label,
      },
      {
        'value': complist[1].id,
        'label': complist[1].label,
      },
    ];
    isloading(false);
    print("hhhhhh");
    print(complainList);
  }

  findsoustypes() async {
    isloading(true);
    souslist = await sousTypesService.findsousTypes();
    sousTypesList = [
      {
        'value': souslist[0].idsous,
        'label': souslist[0].label,
      },
      {
        'value': souslist[1].idsous,
        'label': souslist[1].label,
      },
      {
        'value': souslist[2].idsous,
        'label': souslist[2].label,
      },
      {
        'value': souslist[3].idsous,
        'label': souslist[3].label,
      },
    ];
    print(sousTypesList);
    isloading(false);
  }

  findcomp() async {
    isloading(true);
    List<complainTypeModel> rs = await complainTypeService.findcomplainType();
    cmplist.value = rs.map((e) => e.label).toList();
    isloading(false);
  }

  findComplains() async {
    isloading(true);

    cus_cmpList.value = await cusComplainService.findcomplains();
    print("stttts");
    print(cus_cmpList[0].autre);
print(cus_cmpList.length.toString());
    isloading(false);
  }
}
