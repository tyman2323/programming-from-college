import 'package:flutter/material.dart';
import 'package:homework3/user.dart';

class splash extends StatefulWidget {
  @override
  State<splash> createState() => _splashState();
}

class _splashState extends State<splash> {
  void initState() {
    super.initState();
    navigatetohome();
  }

  navigatetohome() async {
    await Future.delayed(Duration(seconds: 2), () {});
    Navigator.pushReplacement(
        context, MaterialPageRoute(builder: (context) => User()));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                child: Text(
                  'Get Ready To Chat',
                  style: TextStyle(fontSize: 45, fontWeight: FontWeight.bold),
                ),
              ),
            ],
          ),
          SizedBox(
            width: 50,
            height: 50,
            child: Image.network(
                'https://media.tenor.com/YDgENl9PJ5MAAAAC/chatting.gif'),
          )
        ],
      )),
    );
  }
}
