import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:providers_services/core/models/CustomerOrderMou3inaList.dart';
import 'package:providers_services/core/services/OrdresService.dart';
import 'package:http/http.dart' as http;


class ReservationListScreen extends StatefulWidget {
  //final int providerId;

  //ReservationListScreen({required this.providerId});

  @override
  _ReservationListScreenState createState() => _ReservationListScreenState();
}

class _ReservationListScreenState extends State<ReservationListScreen> {
  //List<CustomerOrderMou3inaList> customerOrders = [];
  late Future<List<CustomerOrderMou3inaList>> orders;

  bool isLoading = false;

  /*final OrdersService _reservationService = OrdersService();
  late Future<List<CustomerOrderMou3inaList>> _reservationsFuture;*/

  @override
  void initState() {
    super.initState();
    orders = fetchCustomerOrders();
    /*_reservationsFuture = _reservationService.getReservationsByProviderId(97);
    print(_reservationsFuture);*/
  }

/*  Future<void> fetchCustomerOrders() async {
    final response = await http.get(Uri.parse('http://10.0.2.2:8978/CustomerReservations/ProviderOrder/97'));
    if (response.statusCode == 200) {
      final List<dynamic> responseData = json.decode(response.body);
      setState(() {
        customerOrders = responseData.map((data) => CustomerOrderMou3inaList.fromJson(data)).toList();
      });
    } else {
      // Handle error response
      print('Error: ${response.statusCode}');
    }
  }*/

  Future<List<CustomerOrderMou3inaList>> fetchCustomerOrders() async {
    final response = await http.get(
      Uri.parse('http://10.0.2.2:8978/CustomerReservations/ProviderOrder/97'),
    );
    if (response.statusCode == 200) {
      var jsonResponse = json.decode(response.body);
      List<CustomerOrderMou3inaList> orders = [];
      for (var u in jsonResponse) {
        CustomerOrderMou3inaList order =
        CustomerOrderMou3inaList(id: u['id'],
            //orderDay: u['orderDay'],
            rank: u['rank'],
            serviceCost: u['serviceCost']);
        orders.add(order);
      }
      return orders;
    } else {
      throw Exception('Failed to load post');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Orders'),
      ),
      body: Center(
        child: FutureBuilder<List<CustomerOrderMou3inaList>>(
            future: orders,
            builder: (context, snapshot) {
              if (snapshot.hasData) {
                return ListView.builder(
                    itemCount: snapshot.data!.length,
                    itemBuilder: (context, index) {
                      return ListTile(
                        title: Text("id :"+ snapshot.data![index].id.toString()),
                        subtitle: Text("Order day :"/*+snapshot.data![index].orderDay!.year.toString()+'-'+snapshot.data[index].orderDay!.month.toString()+'-'+snapshot.data[index].orderDay!.day.toString()*/),
                        trailing: Text("Rank :"+ snapshot.data![index].rank.toString()),
                      );
                    });
              } else if (snapshot.hasError) {
                return Text(snapshot.error.toString());
              } else {
                return CircularProgressIndicator();
              }
            }),
      ),
/*      body:  ListView.builder(
      itemCount: customerOrders.length,
      itemBuilder: (BuildContext context, int index) {
        final order = customerOrders[index];
        return Card (
            child : ListTile(
          title: Text('Order ID: ${order.id}'),
          //title: Text('Order ID'),
          subtitle: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
            *//*Text('Order Day'),
              Text('service cost')*//*
                Text('Order Day: ${order.OrderDay.toString()}'),
                Text('Service Cost: ${order.serviceCost.toString()}'),
              ],
            ),
          ),
          );
        },
      ),*/
    );
  }
}