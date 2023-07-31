
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:providers_services/core/models/OrdresModel.dart';


import 'package:shared_preferences/shared_preferences.dart';


class Citeitem extends StatefulWidget {
  const Citeitem({Key? key, this.model, this.onDelete}) : super(key: key);

  final OrdesModel? model;
  final Function? onDelete;

  @override
  State<Citeitem> createState() => _CiteitemState();
}

class _CiteitemState extends State<Citeitem> {
  List<OrdesModel?> city = [];


  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Card(
        elevation: 0,
        margin: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
        child: Container(
            width: 200,
            decoration: BoxDecoration(
                color: Colors.white, borderRadius: BorderRadius.circular(50)),
            child: citeWidget(context)));
  }

  Widget citeWidget(context) {
    return Row(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Padding(padding: EdgeInsets.only(top: 50, bottom: 50, left: 10)),
          //Container(width: 120,alignment: Alignment.center,)
          Text(
            widget.model!.desiredDate!.toString(),
            style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
          ),
          SizedBox(
            width: 10,
          ),
          Text(
            widget.model!.desiredHour!.toString(),
            style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
          ),
          SizedBox(
            height: 10,
          ),

         
          Container(
              width: MediaQuery.of(context).size.width - 180,
              child: Row(mainAxisAlignment: MainAxisAlignment.end, children: [
                GestureDetector(
                  child: Icon(Icons.edit, color: Colors.blue),
                  onTap: () {
                    Navigator.of(context).pushNamed(
                      '/AddSitee',
                      arguments: {'model': widget.model},
                    );
                  },
                ),
                GestureDetector(
                  child: Icon(
                    Icons.delete,
                    color: Colors.red,
                  ),
                  onTap: () {
                    _showMyDialog();
                  },
                ),
              ]))
        ]);
  }

  Future<void> _showMyDialog() async {
    return showDialog<void>(
      context: context,
      barrierDismissible: false, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Delete'),
          content: SingleChildScrollView(
            child: Column(
              children: <Widget>[
                Text('Are you sure to delete this site'),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: Text(
                'Confirm',
                style: TextStyle(color: Colors.red),
              ),
              onPressed: () {
                widget.onDelete!(widget.model);
                print('Confirmed');
                Navigator.of(context).pop();
              },
            ),
            TextButton(
              child: Text('Cancel'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }
}