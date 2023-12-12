import 'package:flutter/material.dart';

class AnimatedContainerExample extends StatefulWidget {
  @override
  _AnimatedContainerExampleState createState() =>
      _AnimatedContainerExampleState();
}

class _AnimatedContainerExampleState extends State<AnimatedContainerExample> {
  double _containerWidth = 100.0;
  double _containerHeight = 100.0;

  void _toggleContainerSize() {
    setState(() {
      _containerWidth = _containerWidth == 100.0 ? 180.0 : 100.0;
      _containerHeight = _containerHeight == 100.0 ? 180.0 : 100.0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Implicit Animation Example'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            AnimatedContainer(
              duration: Duration(seconds: 1),
              width: _containerWidth,
              height: _containerHeight,
              color: Colors.indigo,
              curve: Curves.easeInOut,
            ),
            SizedBox(height: 20),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                primary: Colors.indigo,
                elevation: 9,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(8),
                ),
              ),
              onPressed: _toggleContainerSize,
              child: Text('Toggle Animation'),
            ),
          ],
        ),
      ),
    );
  }
}
