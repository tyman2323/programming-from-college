import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';

class User extends StatefulWidget {
  @override
  State<User> createState() => _UserState();
}

class _UserState extends State<User> {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final email = TextEditingController();
  final password = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          body: Center(
        child: Column(
          children: [
            SizedBox(
              height: 100,
            ),
            Container(
              width: 100,
              height: 100,
              child: Image.network(
                  'https://media.tenor.com/YDgENl9PJ5MAAAAC/chatting.gif'),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              child: Text(
                'Login To Get Chatting!',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              width: 250,
              child: TextField(
                  controller: email,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Email',
                  )),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              width: 250,
              child: TextField(
                  controller: password,
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Password',
                  )),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              child: ElevatedButton(
                  style: ElevatedButton.styleFrom(backgroundColor: Colors.grey),
                  onPressed: () async {
                    try {
                      final UserCredential user =
                          await _auth.signInWithEmailAndPassword(
                        email: email.text,
                        password: password.text,
                      );
                      if (user != null) {
                        Navigator.pushNamed(context, '/doorstep');
                      }
                    } catch (e) {
                      showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return AlertDialog(
                            content: Text(
                                'Incorrect email or password, if you dont have an account make one below.'),
                            actions: <Widget>[
                              TextButton(
                                onPressed: () => Navigator.pop(context, 'OK'),
                                child: const Text('OK'),
                              ),
                            ],
                          );
                        },
                      );
                    }
                  },
                  child: Text(
                    'Login',
                    style: TextStyle(fontSize: 20),
                  )),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              child: TextButton(
                  onPressed: () {
                    Navigator.pushNamed(context, '/register');
                  },
                  child: Text('Dont have an account? Click here to register')),
            )
          ],
        ),
      )),
    );
  }
}
