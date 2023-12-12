import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class register extends StatelessWidget {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final username = TextEditingController();
  final password = TextEditingController();
  final email = TextEditingController();
  final dob = TextEditingController();
  final gender = TextEditingController();
  Future createuser() async {
    final docuser =
        FirebaseFirestore.instance.collection('user').doc(email.text);
    await docuser.set({
      'username': username.text,
      'dob': dob.text,
      'email': email.text,
      'gender': gender.text
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
              'Register below to make an account',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
            ),
          ),
          SizedBox(
            height: 10,
          ),
          Container(
            width: 250,
            child: TextField(
                controller: username,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Username',
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
            width: 250,
            child: TextField(
                controller: email,
                obscureText: false,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Email Address',
                )),
          ),
          SizedBox(
            height: 10,
          ),
          Container(
            width: 250,
            child: TextField(
                controller: dob,
                obscureText: false,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Date of Birth',
                )),
          ),
          SizedBox(
            height: 10,
          ),
          Container(
            width: 250,
            child: TextField(
                controller: gender,
                obscureText: false,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Gender',
                )),
          ),
          SizedBox(
            height: 10,
          ),
          Container(
            child: ElevatedButton(
                style: ElevatedButton.styleFrom(backgroundColor: Colors.grey),
                onPressed: () async {
                  if (dob.text.length < 6 ||
                      username.text.length < 1 ||
                      password.text.length < 1 ||
                      RegExp(r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+")
                              .hasMatch(email.text) ==
                          false) {
                    showDialog(
                      context: context,
                      builder: (BuildContext context) {
                        return AlertDialog(
                          content: Text(
                              'It looks like you haven\'t filled out all the registration fields. Do so to register.'),
                          actions: <Widget>[
                            TextButton(
                              onPressed: () => Navigator.pop(context, 'OK'),
                              child: const Text('OK'),
                            ),
                          ],
                        );
                      },
                    );
                  } else {
                    try {
                      final UserCredential user =
                          await _auth.createUserWithEmailAndPassword(
                        email: email.text,
                        password: password.text,
                      );

                      if (user != null) {
                        createuser();
                        Navigator.pushNamed(context, '/user');
                      }
                    } catch (e) {
                      print(e);
                      showDialog(
                        context: context,
                        builder: (BuildContext context) {
                          return AlertDialog(
                            content: Text(
                                'Password must be 6 characters or longer.'),
                            actions: <Widget>[
                              TextButton(
                                onPressed: () => Navigator.pop(context, 'OK'),
                                child: const Text('OK'),
                              ),
                            ],
                          );
                        },
                      );
                      ;
                    }
                  }
                },
                child: Text(
                  'Register',
                  style: TextStyle(fontSize: 20),
                )),
          ),
        ],
      ),
    ));
  }
}
