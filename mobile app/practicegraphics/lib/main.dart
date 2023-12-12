import 'package:flutter/material.dart';

void main() => runApp(app());

class app extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: CustomPaint(
          foregroundPainter: linepainter(),
        ),
      ),
    );
  }
}

class linepainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint();
    canvas.drawLine(
      Offset(size.width * 1 / 6, size.height * 1 / 2),
      Offset(size.width * 1 / 6, size.height * 1 / 2),
      paint,
    );
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}


//https://www.youtube.com/watch?time_continue=172&v=jaoJz3q9PmE&embeds_referring_euri=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3Dflutter%2Bcustom%2Bpaint%2Bdraw%2Ba%2Bline%26sca_esv%3D567074376%26sxsrf%3DAM9HkKlVp8YqxyjljqTqeXLSd8FDwp8Zug%253A16&source_ve_path=Mjg2NjY&feature=emb_logo