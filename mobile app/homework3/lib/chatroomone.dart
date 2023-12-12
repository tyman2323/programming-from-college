import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:homework3/usermodel.dart';

final FirebaseFirestore firestore = FirebaseFirestore.instance;

class chatroomone extends StatefulWidget {
  @override
  _chatroomonestate createState() => _chatroomonestate();
}

class _chatroomonestate extends State<chatroomone> {
  final messageController = TextEditingController();

  void sendMessage() async {
    final user = await FirebaseAuth.instance.currentUser;
    final userSnapshot =
        await firestore.collection('user').doc(user?.email).get();

    firestore.collection('messages').add({
      'text': messageController.text,
      'timestamp': FieldValue.serverTimestamp(),
      'user': userSnapshot.data(),
    });

    messageController.clear();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Chatroom One'),
        automaticallyImplyLeading: false,
        actions: <Widget>[
          Builder(
            builder: (context) => IconButton(
              icon: Icon(Icons.menu),
              onPressed: () => Scaffold.of(context).openEndDrawer(),
              tooltip: MaterialLocalizations.of(context).openAppDrawerTooltip,
            ),
          ),
        ],
      ),
      endDrawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            ListTile(
              title: Text('Rooms'),
              onTap: () {
                Navigator.pushNamed(context, '/doorstep');
              },
            ),
            ListTile(
              title: Text('Profile'),
              onTap: () {
                Navigator.pushNamed(context, '/profile');
              },
            ),
            ListTile(
              title: Text('Settings'),
              onTap: () {
                Navigator.pop(context);
              },
            ),
          ],
        ),
      ),
      body: Column(
        children: [
          Expanded(
            child: StreamBuilder(
              stream: firestore
                  .collection('messages')
                  .orderBy('timestamp')
                  .snapshots(),
              builder: (BuildContext context,
                  AsyncSnapshot<QuerySnapshot> snapshot) {
                if (snapshot.hasError) {
                  return Text('Error: ${snapshot.error}');
                }

                if (snapshot.connectionState == ConnectionState.waiting) {
                  return CircularProgressIndicator();
                }

                return ListView.builder(
                  itemCount: snapshot.data!.docs.length,
                  itemBuilder: (BuildContext context, int index) {
                    final doc = snapshot.data!.docs[index];
                    final user = doc['user'] != null
                        ? usermodel.fromJson(doc['user'])
                        : usermodel(
                            'DefaultUsername',
                            'DefaultDOB',
                            'DefaultEmail',
                            'DefaultGender',
                          );

                    final isCurrentUser =
                        FirebaseAuth.instance.currentUser?.email ==
                            user.getemail();

                    return Padding(
                      padding: EdgeInsets.symmetric(
                        horizontal: 8.0,
                        vertical: 4.0,
                      ),
                      child: Column(
                        crossAxisAlignment: isCurrentUser
                            ? CrossAxisAlignment.end
                            : CrossAxisAlignment.start,
                        children: [
                          Container(
                            padding: EdgeInsets.all(12),
                            decoration: BoxDecoration(
                              color: isCurrentUser
                                  ? Colors.lightBlue
                                  : Colors.grey,
                              borderRadius: BorderRadius.circular(10),
                            ),
                            child: Text(
                              doc['text'] ?? 'No message text',
                              style: TextStyle(
                                color:
                                    isCurrentUser ? Colors.white : Colors.black,
                                fontSize: 16,
                              ),
                            ),
                          ),
                          SizedBox(height: 4),
                          Text(
                            'Sent by: ${user.getusername() ?? 'Unknown User'}',
                            style: TextStyle(
                              color: Colors.grey,
                              fontSize: 12,
                            ),
                          ),
                        ],
                      ),
                    );
                  },
                );
              },
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: messageController,
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: 'Type your message',
                    ),
                  ),
                ),
                IconButton(
                  icon: Icon(Icons.send),
                  onPressed: sendMessage,
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
