import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:homework3/usermodel.dart';

class profile extends StatefulWidget {
  @override
  _profilestate createState() => _profilestate();
}

class _profilestate extends State<profile> {
  List<String> docid = [];
  final _auth = FirebaseAuth.instance;
  late Future<String> userEmail;
  late Future<usermodel> user;

  @override
  void initState() {
    super.initState();
    userEmail = getCurrentUserEmail();
    user = readuser();
    getdocid();
  }

  Future<String> getCurrentUserEmail() async {
    final user = await _auth.currentUser!;
    return user.email ?? 'Email not available';
  }

  Future getdocid() async {
    await FirebaseFirestore.instance.collection('user').snapshots().map(
        (snapshot) => snapshot.docs
            .map((doc) => usermodel.fromJson(doc.data()))
            .toList());
  }

  Future<usermodel> readuser() async {
    final docuser =
        FirebaseFirestore.instance.collection('user').doc(await userEmail);
    final snapshot = await docuser.get();
    return usermodel.fromJson(snapshot.data()!);
  }

  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: FutureBuilder<List<dynamic>>(
          future: Future.wait([userEmail, user]),
          builder:
              (BuildContext context, AsyncSnapshot<List<dynamic>> snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return CircularProgressIndicator();
            } else {
              return Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    ('Hello ' + snapshot.data?[1].username + '!') ??
                        'Username not available', // Display the username here
                    style: TextStyle(
                      fontSize: 40,
                      color: Color.fromARGB(255, 153, 57, 57),
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Text(
                    snapshot.data?[0] ?? 'Cannot pull email at this time',
                    style: TextStyle(
                      fontSize: 20,
                      color: const Color.fromARGB(255, 133, 73, 73),
                      letterSpacing: 2.5,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(
                    height: 20.0,
                    width: 150,
                    child: Divider(
                      color: Colors.teal.shade100,
                    ),
                  ),
                  Text(
                    snapshot.data?[1].dob ??
                        'Cannot pull birthday at this time',
                    style: TextStyle(
                      fontSize: 20,
                      color: const Color.fromARGB(255, 133, 73, 73),
                      letterSpacing: 2.5,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(
                    height: 20.0,
                    width: 150,
                    child: Divider(
                      color: Colors.teal.shade100,
                    ),
                  ),
                  Text(
                    snapshot.data?[1].gender ??
                        'Cannot pull birthday at this time',
                    style: TextStyle(
                      fontSize: 20,
                      color: const Color.fromARGB(255, 133, 73, 73),
                      letterSpacing: 2.5,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(
                    height: 20.0,
                    width: 150,
                    child: Divider(
                      color: Colors.teal.shade100,
                    ),
                  ),
                  Container(
                    child: IconButton(
                        onPressed: () {
                          Navigator.pop(context);
                        },
                        icon: Icon(Icons.arrow_back_ios)),
                  )
                ],
              );
            }
          },
        ),
      ),
    );
  }
}
