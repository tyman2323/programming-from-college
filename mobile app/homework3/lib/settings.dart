import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:homework3/usermodel.dart';

class settings extends StatefulWidget {
  @override
  _settingsstate createState() => _settingsstate();
}

class _settingsstate extends State<settings> {
  final _auth = FirebaseAuth.instance;
  final _firestore = FirebaseFirestore.instance;
  final _usernameController = TextEditingController();
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _dobController = TextEditingController();
  final _genderController = TextEditingController();

  late Future<String> userEmail;
  late Future<usermodel> user;

  @override
  void initState() {
    super.initState();
    userEmail = getCurrentUserEmail();
    user = readuser();
  }

  Future<String> getCurrentUserEmail() async {
    final user = await _auth.currentUser!;
    return user.email ?? 'Email not available';
  }

  Future<usermodel> readuser() async {
    final docuser =
        FirebaseFirestore.instance.collection('user').doc(await userEmail);
    final snapshot = await docuser.get();
    return usermodel.fromJson(snapshot.data()!);
  }

  Future<void> updateUsername() async {
    var user = await _auth.currentUser;
    final email = await userEmail;

    if (_usernameController.text.isNotEmpty) {
      await _firestore
          .collection('user')
          .doc(email)
          .update({'username': _usernameController.text});

      // Refresh the user data after the update
      setState(() {
        user = readuser() as User?;
      });

      // Clear the text field
      _usernameController.clear();
    }
  }

  Future<void> updateEmail() async {
    var user = await _auth.currentUser;
    final email = await userEmail;

    if (_emailController.text.isNotEmpty) {
      await _firestore
          .collection('user')
          .doc(email)
          .update({'email': _emailController.text});

      // Refresh the user data after the update
      setState(() {
        userEmail = getCurrentUserEmail();
        user = readuser() as User?;
      });

      // Clear the text field
      _emailController.clear();
    }
  }

  Future<void> updatePassword() async {
    var user = await _auth.currentUser;

    if (_passwordController.text.isNotEmpty) {
      await user!.updatePassword(_passwordController.text);

      // Clear the text field
      _passwordController.clear();
    }
  }

  Future<void> updateDOB() async {
    var user = await _auth.currentUser;
    final email = await userEmail;

    if (_dobController.text.isNotEmpty) {
      await _firestore
          .collection('user')
          .doc(email)
          .update({'dob': _dobController.text});

      // Refresh the user data after the update
      setState(() {
        user = readuser() as User?;
      });

      // Clear the text field
      _dobController.clear();
    }
  }

  Future<void> updateGender() async {
    var user = await _auth.currentUser;
    final email = await userEmail;

    if (_genderController.text.isNotEmpty) {
      await _firestore
          .collection('user')
          .doc(email)
          .update({'gender': _genderController.text});

      // Refresh the user data after the update
      setState(() {
        user = readuser() as User?;
      });

      // Clear the text field
      _genderController.clear();
    }
  }

  Future<void> logOut() async {
    await _auth.signOut();
    Navigator.pushNamed(context, '/user');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Settings'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
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
                  TextField(
                    controller: _usernameController,
                    decoration: InputDecoration(
                      labelText: 'Username',
                    ),
                  ),
                  ElevatedButton(
                    onPressed: updateUsername,
                    child: Text('Update Username'),
                  ),
                  SizedBox(height: 20),
                  TextField(
                    controller: _dobController,
                    decoration: InputDecoration(
                      labelText: 'Date of Birth',
                    ),
                  ),
                  ElevatedButton(
                    onPressed: updateDOB,
                    child: Text('Update DOB'),
                  ),
                  SizedBox(height: 20),
                  TextField(
                    controller: _genderController,
                    decoration: InputDecoration(
                      labelText: 'Gender',
                    ),
                  ),
                  ElevatedButton(
                    onPressed: updateGender,
                    child: Text('Update Gender'),
                  ),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: logOut,
                    child: Text('Log Out'),
                  ),
                ],
              );
            }
          },
        ),
      ),
    );
  }
}
