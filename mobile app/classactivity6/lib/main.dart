import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: FadingTextAnimation(),
    );
  }
}

class FadingTextAnimation extends StatefulWidget {
  @override
  _FadingTextAnimationState createState() => _FadingTextAnimationState();
}

class _FadingTextAnimationState extends State<FadingTextAnimation> {
  bool _isVisible = true;
  bool _issize = true;
  bool showmessage = false;
  void toggleVisibility() {
    setState(() {
      _isVisible = !_isVisible;
    });
  }

  void togglesize() {
    setState(() {
      _issize = !_issize;
    });
  }

  void theblocker() {
    setState(() {
      showmessage = !showmessage;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Fading Text Animation'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.all(13.0),
                child: Center(
                  child: AnimatedOpacity(
                    opacity: _isVisible ? 1.0 : 0.0,
                    duration: Duration(seconds: 1),
                    child: Text(
                      'Hello, Flutter!',
                      style: TextStyle(fontSize: 24),
                    ),
                  ),
                ),
              ),
              Container(
                  child: AnimatedSize(
                duration: Duration(seconds: 5),
                child: Text(
                  'this is something',
                  style: TextStyle(
                    fontSize: _issize ? 24.0 : 43.0,
                  ),
                ),
              )),
              Container(
                  height: 100,
                  width: 100,
                  child: Stack(
                    children: [
                      Positioned(
                        bottom: 10,
                        right: 10,
                        child: Text(':)'),
                      ),
                      AnimatedPositioned(
                          child: Text('████████'),
                          right: showmessage ? 70 : 10,
                          bottom: 10,
                          duration: Duration(milliseconds: 500))
                    ],
                  )),
              Container(
                child: FloatingActionButton(
                  onPressed: toggleVisibility,
                  child: Icon(Icons.play_arrow),
                ),
              ),
              Container(
                child: FloatingActionButton(
                  onPressed: togglesize,
                  child: Text('Yeah'),
                ),
              ),
              Container(
                child: FloatingActionButton(
                  onPressed: theblocker,
                  child: Text('Okay'),
                ),
              )
            ],
          ),
        ));
  }
}
