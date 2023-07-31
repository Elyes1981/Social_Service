
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_date_picker/flutter_date_picker.dart';
import 'package:get/get.dart';
import 'package:providers_services/core/models/GenderModel.dart';
import 'package:providers_services/core/models/LangageModel.dart';
import 'package:providers_services/core/models/Mou3inaModel.dart';
import 'package:providers_services/core/models/ServiceModel.dart';
import 'package:providers_services/core/models/StatusModel.dart';
import 'package:providers_services/core/models/cooptedBy.dart';
import 'package:providers_services/core/models/seniorityModel.dart';
import 'package:providers_services/core/routes/app_routes.dart';
import 'package:providers_services/core/services/CooptedByService.dart';
import 'package:providers_services/core/services/DelegationService.dart';
import 'package:providers_services/core/services/GenderService.dart';
import 'package:providers_services/core/services/GouvernoratService.dart';
import 'package:providers_services/core/services/Mou3inaService.dart';
import 'package:providers_services/core/services/ServiceType.dart';
import 'package:providers_services/core/services/StatusService.dart';
import 'package:providers_services/core/services/langageService.dart';
import 'package:providers_services/core/services/seniorityService.dart';
import 'package:providers_services/shared/controllers/generic.controller.dart';

class ServiceTypeController extends GenericController{

    static ServiceTypeController instance = Get.find();
    ServiceType serviceType=Get.find();
    SeniorityService seniorityService=Get.find();
    CooptedByService cooptedByService=Get.find();
    delegationService delegationservice=Get.find();
    LangageService langageService=Get.find();
    GenderService genderService=Get.find();
    StatusService statusService=Get.find();
    Mou3inaService mou3inaService=Get.find();
    GouvernoratService gouvernoratService=Get.find();

    
    late List<Map<String, dynamic>> seniorityList=[];
    late List<Map<String, dynamic>> cooptedList =[];
    late List<Map<String, dynamic>> genderList=[];
    late List<Map<String, dynamic>> StatusList=[];
    late List<Map<String, dynamic>> serviceTypeList =[];
    //RxList<LangageModel> selectedValuess = List<LangageModel>.empty().obs;
    //RxList<ServiceModel> selectedValues = List<ServiceModel>.empty().obs;
    late List<Map<String, dynamic>> selectedValues =[];
    late List<Map<String, dynamic>> selectedValuess =[];



    RxBool isLoading = true.obs;
    RxBool isLoadingLangage = true.obs;
    RxBool isSelected = false.obs;
    String? smartPhone ;
    String? vip ;

    late TextEditingController firstName ;
    late TextEditingController dateinput ;
    late TextEditingController lastName;
    late TextEditingController home_Adress ;
    late TextEditingController rib ;
    late TextEditingController emailAdress;
    late TextEditingController documentIdType;
    late TextEditingController phone;
    late  TextEditingController phone2 ;
    late  TextEditingController comment ;
    late  TextEditingController username ;
    late  TextEditingController password ;
    late  TextEditingController hasASmartPhone ;
    late  TextEditingController video ;
    late Mou3inaEntity mou3ina;
    String? genderSelected ;
    double? x;
    double? y;
    String? statusSelected ;
    String? senioritySelected ;
    String? cooptedSelected ;
    List<GenderModel> g=[];
    List<StatusModel> st=[];
    List<SeniorityModel> s=[];
    List<CooptedByModel> cs=[];
    List<ServiceModel> rs=[];
    List<LangageModel> ls=[];


    @override
    void onInit() {
      print("on init");
      findServiceTypes();
 
  
      video  = new  TextEditingController()  ;
      dateinput  = new  TextEditingController()  ;
      comment  = new  TextEditingController()  ;
      username  = new  TextEditingController()  ;
      password  = new  TextEditingController()  ;
      hasASmartPhone  = new  TextEditingController () ;
      firstName = new TextEditingController();
      lastName = new TextEditingController();
      home_Adress = new TextEditingController();
      rib = new TextEditingController();
      emailAdress = new TextEditingController();
      phone = new TextEditingController();
      phone2 = new TextEditingController();
      documentIdType = new TextEditingController();

      super.onInit();
    }

    save(ServiceModel service){
    print(selectedValues);
    isSelected.value=true;
    selectedValues.add(service as Map<String, dynamic>);
    print(selectedValues);
    isSelected.value=false;
    print(selectedValues);
    }


    final List<Map<String, dynamic>> Listvip = [
      {
        'value': 'yes',
        'label': 'yes',
     
      },
      {
        'value': 'no',
        'label': 'no',
      
      },
 
    ];
    final List<Map<String, dynamic>> Listsmartphone = [
        {
          'value': 'yes',
          'label': 'yes',

        },
        {
          'value': 'no',
          'label': 'no',

        },

    ];


    @override
    void initialization() async {

      firstName = new TextEditingController();
      lastName = new TextEditingController();
      home_Adress = new TextEditingController();
      rib = new TextEditingController();
      emailAdress = new TextEditingController();
      phone = new TextEditingController();
      phone2 = new TextEditingController();
      documentIdType = new TextEditingController();
      comment  = new  TextEditingController()  ;
      username  = new  TextEditingController()  ;
      password  = new  TextEditingController()  ;
      hasASmartPhone  = new  TextEditingController  ();
      video  = new  TextEditingController()  ;
      dateinput  = new  TextEditingController()  ;



      super.initialization();
    }


    findServiceTypes() async{
      print("*********test ***************");
      isLoading(true);
      rs= await serviceType.findServiceTypes();

      print("findLangageSpeaking");
      print(rs);
      ls= await langageService.findLangage();
      print("fetching LangageModel");
      print(ls);

      cs= await cooptedByService.findCooptedBy();
      cooptedList = [
      {
        'value':cs[2].id,
        'label':Get.locale!.languageCode=='ar'? cs[2].label_ar:Get.locale!.languageCode=='fr'?cs[2].label_fr:Get.locale!.languageCode=='en'? cs[2].label:'en',
        'textStyle': TextStyle(color: Colors.black),
      },
      {
        'value': cs[1].id,
       'label':Get.locale!.languageCode=='ar'? cs[1].label_ar:Get.locale!.languageCode=='fr'?cs[1].label_fr:Get.locale!.languageCode=='en'? cs[1].label:'en',
      },
      {
        'value': cs[0].id,
        'label':Get.locale!.languageCode=='ar'? cs[0].label_ar:Get.locale!.languageCode=='fr'?cs[0].label_fr:Get.locale!.languageCode=='en'? cs[0].label:'en',
      },
      ];

      s= await seniorityService.findseniority();
      seniorityList = [
        {
          'value': s[0].id,
          'label':Get.locale!.languageCode=='ar'? s[0].label_ar:Get.locale!.languageCode=='fr'?s[0].label_fr:Get.locale!.languageCode=='en'? s[0].label:'en',
          'textStyle': TextStyle(color: Colors.black),
        },
        {
          'value': s[1].id,
         'label':Get.locale!.languageCode=='ar'? s[1].label_ar:Get.locale!.languageCode=='fr'?s[1].label_fr:Get.locale!.languageCode=='en'? s[1].label:'en',
           'textStyle': TextStyle(color: Colors.black),

        },
        {
          'value': s[2].id,
           'label':Get.locale!.languageCode=='ar'? s[2].label_ar:Get.locale!.languageCode=='fr'?s[2].label_fr:Get.locale!.languageCode=='en'? s[2].label:'en',
           'textStyle': TextStyle(color: Colors.black),
        },
        {
          'value': s[3].id,
          'label':Get.locale!.languageCode=='ar'? s[3].label_ar:Get.locale!.languageCode=='fr'?s[3].label_fr:Get.locale!.languageCode=='en'? s[3].label:'en',
           'textStyle': TextStyle(color: Colors.black),
        },



      ];


    print(seniorityList);
    print("amal");
    g = await genderService.findGender();
        genderList = [
      {
        'value': g[0].id,
         'label':Get.locale!.languageCode=='ar'? g[0].label_ar:Get.locale!.languageCode=='fr'?g[0].label_fr:Get.locale!.languageCode=='en'? g[0].label:'en',
         'textStyle': TextStyle(color: Colors.black),


      },
      {
        'value': g[1].id,
        'label':Get.locale!.languageCode=='ar'? g[1].label_ar:Get.locale!.languageCode=='fr'?g[1].label_fr:Get.locale!.languageCode=='en'? g[1].label:'en',
         'textStyle': TextStyle(color: Colors.black),

      },
    ];

    print(genderList);
    st= await statusService.findStatus();
    StatusList = [
      {
        'value': st[0].id,
        'label':Get.locale!.languageCode=='ar'? st[0].label_ar:Get.locale!.languageCode=='fr'?st[0].label_fr:Get.locale!.languageCode=='en'? st[0].label:'en',

      },
      {
        'value': st[1].id,
        'label':Get.locale!.languageCode=='ar'? st[1].label_ar:Get.locale!.languageCode=='fr'?st[2].label_fr:Get.locale!.languageCode=='en'? st[2].label:'en',
        'textStyle': TextStyle(color: Colors.black),
      },
      {
        'value': st[2].id,
        'label':Get.locale!.languageCode=='ar'? st[2].label_ar:Get.locale!.languageCode=='fr'?st[2].label_fr:Get.locale!.languageCode=='en'? st[2].label:'en',
      }


    ];
       print("stausService");
       print(StatusList);

     isLoading(false);
    }

    Future<void> createMou3ina() async {
      try {

        final Mou3inaEntity response = await mou3inaService.create(mou3ina!);

        Get.offAndToNamed(AppRoutes.login);

        initialization();
      } catch (e) {
        print(e);

      }
    }
  
    addMou3ina(bool isValid) async {
      if (isValid) {
        mou3ina = new Mou3inaEntity();
        mou3ina.firstName = firstName.text;
        mou3ina.lastName = lastName.text;
        mou3ina.emailAdress = emailAdress.text;
        mou3ina.home_Adress = home_Adress.text;
        mou3ina.rib = rib.text;
        mou3ina.phone = phone.text ;
        mou3ina.phone2 = phone2.text ;
        mou3ina.documentIdType = documentIdType.text ;
        mou3ina.comment = comment.text ;
        mou3ina.vip = vip ;
        mou3ina.username = username.text ;
        mou3ina.password =password.text ;
        mou3ina.hasASmartPhone = smartPhone ;
        mou3ina.video = video.text ;
        mou3ina.birthday=dateinput.text;
        mou3ina.home_Adress_GPS_latt=x;
        mou3ina.home_Adress_GPS_long=y;
        print("heloo");
        print(g);
        GenderModel genre = g.firstWhere((element) => element.id.toString() == genderSelected);
        print(genre);
        mou3ina.gender = genre;
        print(genre);
           
        StatusModel status = st.firstWhere((element) => element.id.toString() == statusSelected);
        print(status);
        mou3ina.status = status;
        print(status);

        CooptedByModel coopted = cs.firstWhere((element) => element.id.toString() == cooptedSelected);
      
        print(coopted);
        mou3ina.cooptedBy = coopted;
        print(coopted);


        SeniorityModel senior = s.firstWhere((element) => element.id.toString() == senioritySelected);   
        print(s);
        print(senior);
        mou3ina.seniority = senior;
        mou3ina.serviceType= selectedValues.cast<ServiceModel>();
        mou3ina.langageSpeaking = selectedValuess.cast<LangageModel>();
        await createMou3ina();
        print("success");
        print(mou3ina);
        }
      else
        {
          print("failed");
        }
      
    }
  
 


    @override
    void onClose(){
      super.onClose();
    }
  }
  
 