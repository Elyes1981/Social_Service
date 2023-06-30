import 'package:flutter/material.dart';


class test extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Changer de langue',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: LanguagePage(),
    );
  }
}

class LanguagePage extends StatefulWidget {
  @override
  _LanguagePageState createState() => _LanguagePageState();
}

class _LanguagePageState extends State<LanguagePage> {
  String? _selectedLanguage = 'Français'; // Langue par défaut
  String _greeting = 'Bonjour'; // Message de salutation par défaut

  void _changeLanguage(String? language) {
    setState(() {
      _selectedLanguage = language;
      if (language == 'English') {
        _greeting = 'Hello';
      } else if(language == 'Français'){
        _greeting = 'Bonjour';
      }
      else {
      _greeting = 'صباح الخير';
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Changer de langue'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              _greeting,
              style: TextStyle(fontSize: 24),
            ),
            SizedBox(height: 16),
            DropdownButton<String>(
              value: _selectedLanguage,
              onChanged: _changeLanguage,
              items: ['Français', 'English', 'Arabe']
                  .map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
          ],
        ),
      ),
    );
  }
}
