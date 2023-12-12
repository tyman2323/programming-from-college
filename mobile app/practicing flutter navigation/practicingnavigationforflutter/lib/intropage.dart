import 'package:flutter/material.dart';

class intropage extends StatefulWidget {
  const intropage({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Intro Page")),
      body: Center(
        child: ElevatedButton(
            child: const Text("Go home"),
            onPressed: () {
              Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => intropage(),
                  ));
            }),
      ),
    );
  }

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    throw UnimplementedError();
  }
}
