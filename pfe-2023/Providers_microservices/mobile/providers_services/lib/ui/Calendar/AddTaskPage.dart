import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:intl/intl.dart';
import 'package:providers_services/core/models/Task.dart';
import 'package:providers_services/ui/Calendar/MyInputField.dart';
import 'package:providers_services/ui/Calendar/button.dart';
import 'package:providers_services/ui/Calendar/task_controller.dart';
import 'package:providers_services/ui/Calendar/theme.dart';
import 'package:providers_services/ui/profil/profilController.dart';

class AddTaskPage extends StatefulWidget {
  

  @override
  State<AddTaskPage> createState() => _State();
}

class _State extends State<AddTaskPage> {
  @override
final TaskController _taskController =Get.put(TaskController());
  DateTime _SelectedDate =DateTime.now();
  String _startTime =DateFormat('hh:mm:a').format(DateTime.now()).toString();
  String _endTime="9:30 PM";
  int _selectedRemind=5;
  List<int> remindList=[5, 10 ,15 ,20,];
   String _selectedRepeat ="33".tr ;
   String _titleController="";
   String _noteController="";

    List<String> repeatList=["33".tr, "34".tr];
     List<String> titleList=["35".tr, "36".tr];
      List<String> noteList=["37".tr, "38".tr,"39".tr];
    int _seletedColor =0;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
       appBar: AppBar(
       title: Text( "21".tr),
       centerTitle: true,

    ),
    body: Container(
      child: SingleChildScrollView(child: Column(
        children: [
          
            MyInputField(title: "6".tr, hint: "$_titleController",
        widget:DropdownButton(
          icon: Icon(Icons.arrow_drop_down,
          color: Colors.grey,),
          
          iconSize: 32,
          elevation: 4,
          
          items: titleList.map<DropdownMenuItem<String>>((String value){
            return DropdownMenuItem<String>(
              value: value.toString(),
              child: Text(value));
          }).toList(),
           onChanged: (String? newValue) { 
            setState(() {
              _titleController= newValue!;
            });
            },
          )
          ,
          
       ), 
        MyInputField(title: "22".tr, hint: "$_noteController",
        widget:DropdownButton(
          icon: Icon(Icons.arrow_drop_down,
          color: Colors.grey,),
          
          iconSize: 32,
          elevation: 4,
          
          items: noteList.map<DropdownMenuItem<String>>((String value){
            return DropdownMenuItem<String>(
              value: value.toString(),
              child: Text(value));
          }).toList(),
           onChanged: (String? newValue) { 
            setState(() {
              _noteController= newValue!;
            });
            },
          )
          ,
          
       ), 
         // MyInputField(title: "Absent/present", hint: "enter your title",controller: _titleController,),
          // MyInputField(title: "Note:morning/evening", hint: "enter your Note",controller: _noteController,),
            MyInputField(title: "23".tr, hint: DateFormat.yMd().format(_SelectedDate)

              , widget: IconButton(
            icon: Icon(Icons.calendar_today_outlined),
             onPressed: (){
              print("hi");
              getDateFormUser();
             })
            ),
           Row(
               children: [
                Expanded(
                  child: MyInputField(
                    title: "24".tr, hint: _startTime,
                    widget: IconButton(onPressed: (){
                      getTimeFormUser(isStarTime: true);
                    },
                    icon: Icon(
                      Icons.access_time_rounded,
                      color: Colors.grey
                    ),
                    ))
                    ),
                    SizedBox(width: 12,),
                     Expanded(
                  child: MyInputField(
                    title: "25".tr, hint: _endTime,
                    widget: IconButton(onPressed: (){
                       getTimeFormUser(isStarTime: false);
                    },
                    icon: Icon(
                      Icons.access_time_rounded,
                      color: Colors.grey
                    ),
                    ))
                    ),
               ],
           ),
          MyInputField(title: "26".tr, hint: "$_selectedRemind minutes early",
        widget:DropdownButton(
          icon: Icon(Icons.arrow_drop_down,
          color: Colors.grey,),
          
          iconSize: 32,
          elevation: 4,
          
          items: remindList.map<DropdownMenuItem<String>>((int value){
            return DropdownMenuItem<String>(
              value: value.toString(),
              child: Text(value.toString()));
          }).toList(),
           onChanged: (String? newValue) { 
            setState(() {
              _selectedRemind=int.parse(newValue!);
            });
            },
          )
          ,
          
       ),
             MyInputField(title: "27".tr, hint: "$_selectedRepeat",
        widget:DropdownButton(
          icon: Icon(Icons.arrow_drop_down,
          color: Colors.grey,),
          
          iconSize: 32,
          elevation: 4,
          
          items: repeatList.map<DropdownMenuItem<String>>((String value){
            return DropdownMenuItem<String>(
              value: value.toString(),
              child: Text(value));
          }).toList(),
           onChanged: (String? newValue) { 
            setState(() {
              _selectedRepeat= newValue!;
            });
            },
          )
          ,
          
       ), 
       SizedBox(height: 18,),
       Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children:[
              Text("28".tr,),
              Wrap(
                children: 
                  List<Widget>.generate(
                    3,
                     ( int index) {
                      return GestureDetector(

                        onTap: (){
                          setState(() {
                             _seletedColor=index ;
                          });
                         
                        },
                      child:Padding(
                        padding: const EdgeInsets.only(right: 8.0),
                        child: CircleAvatar(
                          radius: 14,
                          backgroundColor :index==0?primaryClr:index==1?pinkClr:yellowClr
                          ,child: _seletedColor==index?Icon(Icons.done,
                          color: Colors.white,
                          size: 16,):Container(),
                       
                       
                        ),
                      )  
                      );
                     }
                     ),
              )
                ],
              )
          
          
          ,MyButton(label: "29".tr, onTap: ()=>validateDate())
            ]
          )
        ],
       )
       
       
    
     
      )
      ),
    );
    
  }


  validateDate(){
    if(_titleController.isNotEmpty&&_noteController.isNotEmpty)

  {
    _addTaskToDb();
    Get.back();}
  else if (_titleController.isEmpty|| _noteController.isEmpty)
   {
    Get.snackbar("40".tr,"41".tr,
    snackPosition:SnackPosition.BOTTOM,
    backgroundColor: Colors.red,
    icon:Icon(Icons.warning_amber_rounded)
    );
   }

  }
  _addTaskToDb() async{
  int value= await _taskController.addTask(
         task:Task(
      note: _noteController,
      title: _titleController,
      date: DateFormat.yMd().format(_SelectedDate),
      startTime: _startTime,
      endTime: _endTime,
      remind: _selectedRemind,
      repeat: _selectedRepeat,
      color: _seletedColor,
      isCompleted: 0,
      idMou3ina:profilController.instance.name,

    )
   
    );
  
print("my id is "+" $value");
  }
  getDateFormUser() async{
  DateTime?  _pickerDate =await showDatePicker(
  context: context,
   initialDate: DateTime.now(), firstDate: DateTime(2015), lastDate: DateTime(2122));
   if(_pickerDate!=null){
setState(() {
  _SelectedDate= _pickerDate;
});
   }else{
    print("it's null or something is wrong");
   }
}

  getTimeFormUser({required bool isStarTime}) async{
var pickerdTime = await _showTimePicker();
String _formatedTime =pickerdTime.format(context);
if(pickerdTime==null){
  print("time canceld");
}else if(isStarTime==true){
  setState(() {
      _startTime=_formatedTime ;
  });


}else if(isStarTime==false){
  setState(() {
      _endTime=_formatedTime ;
  });
 
}
}
_showTimePicker(){
  return showTimePicker(
    initialEntryMode: TimePickerEntryMode.input,
    context: context, 
  initialTime: TimeOfDay(
    hour: int.parse(_startTime.split(":")[0]),
     minute: int.parse(_startTime.split(":")[1].split("")[0]),
    ));
}
}
