import 'package:flutter/material.dart';

void main() => runApp(ExplicitAnimationApp());

class ExplicitAnimationApp extends StatefulWidget {
  @override
  _ExplicitAnimationAppState createState() => _ExplicitAnimationAppState();
}

class _ExplicitAnimationAppState extends State<ExplicitAnimationApp>
    with SingleTickerProviderStateMixin {
  AnimationController _controller;
  Animation<double> _opacityAnimation;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: Duration(seconds: 2),
    );
    _controller.addStatusListener((status) {
      if (status == AnimationStatus.completed) {
        _controller.reverse();
      } else if (status == AnimationStatus.dismissed) {
        _controller.forward();
      }
    });
    _opacityAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(_controller);
    _controller.forward();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Explicit Animation Demo'),
        ),
        body: Center(
          child: AnimatedBuilder(
            animation: _controller,
            builder: (context, child) {
              return Opacity(
                opacity: _opacityAnimation.value,
                child: Text(
                  'Educative.io',
                  style:TextStyle(
                    color:Colors.black,
                    fontSize:40,
                    fontWeight:FontWeight.bold,
                  )
                  ,
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}
