import 'package:flutter/material.dart';
import 'package:homework3/chatroomfour.dart';
import 'package:homework3/chatroomone.dart';
import 'package:homework3/chatroomthree.dart';
import 'package:homework3/chatroomtwo.dart';
import 'package:homework3/doorstep.dart';
import 'package:homework3/profile.dart';
import 'package:homework3/register.dart';
import 'package:homework3/settings.dart';
import 'package:homework3/splash.dart';
import 'package:homework3/user.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(app());
}

class app extends StatefulWidget {
  @override
  State<app> createState() => _appState();
}

class _appState extends State<app> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: {
        '/register': (context) => register(),
        '/user': (context) => User(),
        '/doorstep': (context) => doorstep(),
        '/chatroom': (context) => chatroomone(),
        '/chatroomtwo': (context) => chatroomtwo(),
        '/chatroomthree': (context) => chatroomthree(),
        '/chatroomfour': (context) => chatroomfour(),
        '/profile': (context) => profile(),
        '/settings': (context) => settings()
      },
      home: splash(),
    );
  }
}
