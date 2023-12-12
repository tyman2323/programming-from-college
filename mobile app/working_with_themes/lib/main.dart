import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _RunMyAppState();
}

class _RunMyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        darkTheme: ThemeData.dark(),
        home: Scaffold(
          appBar: AppBar(
            title: Text('mobile app thing'),
          ),
          body: Center(
            child: Column(
              children: [
                Text('data'),
                Row(
                  children: [
                    ElevatedButton(
                        onPressed: () {
                          changeTheme:
                          (ThemeMode.light);
                        },
                        child: Text('click here')),
                    ElevatedButton(
                        onPressed: () {
                          changeTheme:
                          (ThemeMode.dark);
                        },
                        child: Text('clickhere'))
                  ],
                )
              ],
            ),
          ),
        ));
  }
}
