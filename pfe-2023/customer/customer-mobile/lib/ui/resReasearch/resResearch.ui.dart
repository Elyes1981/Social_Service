import 'package:flutter/material.dart';
import 'package:flutter_slidable/flutter_slidable.dart';

class SlidableScreen extends StatefulWidget {
  const SlidableScreen({Key? key}) : super(key: key);

  @override
  State<SlidableScreen> createState() => _SlidableScreenState();
}

class _SlidableScreenState extends State<SlidableScreen> {
  final itemList = [
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Islem ',
      'desc': '45 DT',
    },
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Mounira ',
      'desc': '50 DT',
    },
    {
      'image': 'assets/images/imaMo.jpg',
      'title': 'Eya',
      'desc': '55 DT',
    }
  ];

  int selectedItemIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('validation of choice'),
        backgroundColor: Colors.green,
      ),
      body: Column(
        children: [
          Expanded(
            child: (itemList.isEmpty)
                ? SizedBox(
              height: double.infinity,
              width: double.infinity,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: const [
                  Icon(
                    Icons.hourglass_empty_rounded,
                    color: Colors.grey,
                    size: 60.0,
                  ),
                  SizedBox(height: 10.0),
                  Text(
                    'No item...',
                    style: TextStyle(fontSize: 24.0, color: Colors.grey),
                  )
                ],
              ),
            )
                : ListView.builder(
              itemCount: itemList.length,
              itemBuilder: (context, index) {
                final item = itemList[index];

                return Padding(
                  padding: (index == 0)
                      ? const EdgeInsets.symmetric(vertical: 20.0)
                      : const EdgeInsets.only(bottom: 20.0),
                  child: Slidable(
                    key: Key('$item'),
                    startActionPane: ActionPane(
                      motion: const ScrollMotion(),
                      children: [
                        SlidableAction(
                          onPressed: (context) {},
                          backgroundColor: Colors.green[300]!,
                          icon: Icons.share,
                        ),
                      ],
                    ),
                    endActionPane: ActionPane(
                      motion: const ScrollMotion(),
                      children: [
                        SlidableAction(
                          onPressed: (context) {
                            setState(() {
                              itemList.removeAt(index);
                            });
                          },
                          backgroundColor: Colors.red,
                          icon: Icons.delete,
                        ),
                      ],
                    ),
                    child: GestureDetector(
                      onTap: () {
                        setState(() {
                          selectedItemIndex = index;
                        });
                      },
                      child: Container(
                        margin: const EdgeInsets.symmetric(horizontal: 20.0),
                        padding: const EdgeInsets.all(10.0),
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10.0),
                          color: (index == selectedItemIndex)
                              ? Colors.green[100]
                              : Colors.white,
                          boxShadow: [
                            BoxShadow(
                              blurRadius: 1.0,
                              spreadRadius: 1.0,
                              color: Colors.green[400]!,
                            ),
                          ],
                        ),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.start,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            ClipRRect(
                              borderRadius: BorderRadius.circular(10.0),
                              child: Image.asset(
                                item['image']!,
                                width: 100.0,
                                height: 100.0,
                                fit: BoxFit.cover,
                              ),
                            ),
                            const SizedBox(width: 10.0),
                            Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  item['title']!,
                                  style: const TextStyle(
                                    fontSize: 18.0,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.deepPurple,
                                  ),
                                ),
                                const SizedBox(height: 10.0),
                                Text(
                                  item['desc']!,
                                  style: const TextStyle(
                                    fontSize: 14.0,
                                    color: Colors.grey,
                                  ),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                );

              },

            ),

          ),
          SizedBox(
            height: 20.0,
          ),
          SizedBox(
            width: double.infinity,
            child: ElevatedButton(
              /*  onPressed: () async {
                                      controller.createReservation();
                                      controller.addreservation(
                                          _formKey.currentState!.validate());
                                      await Navigator.push(
                                        context,
                                        MaterialPageRoute(builder: (context) => MessageScreen()),
                                      );
                                    },*/
              onPressed: () async {
                //controller.createReservation();
                bool isValide;
                print("valide1");
               /* if (isValide=_formKey.currentState!.validate()) {
                  // Valider le formulaire avant d'ajouter la réservation
                  //controller.addreservation(isValide);
                  print("valide2");

                  // Naviguer vers l'écran suivant
                  await Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => SlidableScreen()),
                  );
                }*/
              },

              style: ButtonStyle(
                foregroundColor:
                MaterialStateProperty.all<Color>(
                    Colors.white),
                backgroundColor:
                MaterialStateProperty.all<Color>(
                  Color.fromARGB(255, 213, 211, 211),
                ),
                shape: MaterialStateProperty.all<
                    RoundedRectangleBorder>(
                  RoundedRectangleBorder(
                    borderRadius:
                    BorderRadius.circular(24.0),
                  ),
                ),
              ),
              child: Padding(
                padding: EdgeInsets.all(14.0),
                child: Text(
                  'research',
                  style: TextStyle(fontSize: 16),
                ),
              ),
            ),
          ),
          SizedBox(
            height: 20.0,
          ),
          SizedBox(
            width: double.infinity,
            child: ElevatedButton(
              /*  onPressed: () async {
                                      controller.createReservation();
                                      controller.addreservation(
                                          _formKey.currentState!.validate());
                                      await Navigator.push(
                                        context,
                                        MaterialPageRoute(builder: (context) => MessageScreen()),
                                      );
                                    },*/
              onPressed: () async {

              },

              style: ButtonStyle(
                foregroundColor:
                MaterialStateProperty.all<Color>(
                    Colors.white),
                backgroundColor:
                MaterialStateProperty.all<Color>(
                  Color.fromARGB(255, 56, 5, 85),
                ),
                shape: MaterialStateProperty.all<
                    RoundedRectangleBorder>(
                  RoundedRectangleBorder(
                    borderRadius:
                    BorderRadius.circular(24.0),
                  ),
                ),
              ),
              child: Padding(
                padding: EdgeInsets.all(14.0),
                child: Text(
                  'Order',
                  style: TextStyle(fontSize: 16),
                ),
              ),
            ),
          ),

        ],
      ),
    );
  }
}
