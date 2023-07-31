import 'package:flutter/material.dart';

class CheckoutPage extends StatefulWidget {
  const CheckoutPage({Key? key}) : super(key: key);

  @override
  State<CheckoutPage> createState() => _CheckoutPageState();
}

class _CheckoutPageState extends State<CheckoutPage> {
  static const _steps = [
    Step(
      title: Text('Address'),
      content: _AddressForm(),
    ),
    Step(
      title: Text('Card Details'),
      content: _CardForm(),
    ),
    Step(
      title: Text('Overview'),
      content: _Overview(),
    )
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Checkout'),
      ),
      body: Stepper(
        steps: _steps,
      ),
    );
  }
}

class _AddressForm extends StatelessWidget {
  const _AddressForm({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'Street',
          ),
        ),
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'City',
          ),
        ),
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'Postcode',
          ),
        ),
      ],
    );
  }
}

class _CardForm extends StatelessWidget {
  const _CardForm({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'Card number',
          ),
        ),
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'Expiry date',
          ),
        ),
        TextFormField(
          decoration: const InputDecoration(
            labelText: 'CVV',
          ),
        ),
      ],
    );
  }
}

class _Overview extends StatelessWidget {
  const _Overview({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: const [
        Center(child: Text('Thank you for your order!')),
      ],
    );
  }
}
