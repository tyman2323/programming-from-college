import 'package:flutter/material.dart';

class doorstep extends StatelessWidget {
  Widget buildChatRoomButton(
      BuildContext context, String route, String buttonText) {
    return Row(
      children: [
        Expanded(
          child: Container(
            height: 100,
            child: InkWell(
              onTap: () {
                Navigator.pushNamed(context, route);
              },
              child: Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.blue, width: 2.0),
                  borderRadius: BorderRadius.circular(8.0),
                ),
                child: Center(
                  child: Text(
                    buttonText,
                    style: TextStyle(color: Colors.blue),
                  ),
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
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
                Navigator.pushNamed(context, '/settings');
              },
            ),
          ],
        ),
      ),
      body: Container(
        alignment: Alignment.center,
        padding: EdgeInsets.all(32),
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage('assets/bgds.png'),
            fit: BoxFit.fill,
          ),
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            buildChatRoomButton(context, '/chatroom', ''),
            SizedBox(height: 20),
            buildChatRoomButton(context, '/chatroomtwo', ''),
            SizedBox(height: 20),
            buildChatRoomButton(context, '/chatroomthree', ''),
            SizedBox(height: 20),
            buildChatRoomButton(context, '/chatroomfour', ''),
          ],
        ),
      ),
    );
  }
}
