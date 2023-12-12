import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatefulWidget {
  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _animation;
  int speed = 1;
  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      duration: Duration(seconds: speed),
      vsync: this,
    )..repeat(reverse: true);

    _animation = Tween<double>(begin: 290, end: 0).animate(_controller);
  }

  void startmoving() {
    _controller.repeat(reverse: true);
  }

  void stopmoving() {
    _controller.stop();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [
            Container(
              height: 300,
              width: 300,
              child: Stack(
                children: [
                  AnimatedBuilder(
                    animation: _animation,
                    builder: (BuildContext context, _) {
                      return Positioned(
                        top: _animation.value,
                        left: 150,
                        child: Container(
                          height: 10,
                          width: 10,
                          child: IconButton(
                            onPressed: () {},
                            icon: Icon(Icons.circle),
                          ),
                        ),
                      );
                    },
                  ),
                ],
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Padding(
                  padding: const EdgeInsets.all(15.0),
                  child: ElevatedButton(
                      onPressed: this.startmoving, child: Text('Start')),
                ),
                Padding(
                  padding: const EdgeInsets.all(15.0),
                  child: ElevatedButton(
                      onPressed: this.stopmoving, child: Text('Stop')),
                ),
              ],
            ),
            Container(
              width: 100,
              height: 100,
              child: Slider(
                value: speed.toDouble(),
                min: 1,
                max: 10,
                onChanged: (value) {
                  setState(() {
                    speed = value.toInt();
                    _controller.duration = Duration(seconds: speed);
                    if (_controller.isAnimating) {
                      _controller.repeat(reverse: true);
                    }
                  });
                },
              ),
            )
          ],
        ),
      ),
    );
  }
}
