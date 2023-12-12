import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) => MyHomePage(),
        // '/pageTwo': (context) => pagetwo(),
      },
    );
  }
}

class MyHomePage extends StatelessWidget {
  final String img1 =
      'https://external-preview.redd.it/aG8J3JUEShHxgKVq1xYlgwlzTkRklFGhdyg02bE1WkE.jpg?auto=webp&s=b05eaf0f979c68d26d227de61d2840c72a460937';
  final String img2 = 'https://i.redd.it/8dhkrcil2xt41.jpg';
  final String img3 = 'https://i.redd.it/ylx07ibjxl231.jpg';
  final String img4 =
      'https://upload.wikimedia.org/wikipedia/commons/d/de/An_image_of_a_toast_sandwich%2C_shot_from_the_side.jpg';
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('My Recipes'),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Container(
              child: Column(
                children: [
                  Container(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => pagetwo(2, img2)));
                      },
                      child: Ink.image(
                        image: NetworkImage(img2),
                        height: 100,
                        width: 100,
                      ),
                    ),
                    padding: EdgeInsets.all(12.0),
                  ),
                  Container(
                    child: Text(
                      'Ice Soup',
                      style: TextStyle(
                        fontSize: 25,
                      ),
                    ),
                  )
                ],
              ),
            ),
            Container(
              alignment: Alignment.center,
              child: Column(
                children: [
                  Container(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => pagetwo(3, img3)));
                      },
                      child: Ink.image(
                        image: NetworkImage(img3),
                        height: 100,
                        width: 100,
                      ),
                    ),
                    padding: EdgeInsets.all(12.0),
                  ),
                  Container(
                    child: Text(
                      'Beans on Toast',
                      style: TextStyle(
                        fontSize: 25,
                      ),
                    ),
                  )
                ],
              ),
            ),
            Container(
              alignment: Alignment.center,
              child: Column(
                children: [
                  Container(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => pagetwo(4, img4)));
                      },
                      child: Ink.image(
                        image: NetworkImage(img4),
                        height: 100,
                        width: 100,
                      ),
                    ),
                    padding: EdgeInsets.all(12.0),
                  ),
                  Container(
                    child: Text(
                      'Toast on Toast',
                      style: TextStyle(
                        fontSize: 25,
                      ),
                    ),
                  )
                ],
              ),
            ),
            Container(
              alignment: Alignment.center,
              child: Column(
                children: [
                  Container(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => pagetwo(1, img1)));
                      },
                      child: Ink.image(
                        image: NetworkImage(img1),
                        height: 100,
                        width: 100,
                      ),
                    ),
                    padding: EdgeInsets.all(12.0),
                  ),
                  Container(
                    child: Text(
                      'Mushy Peas',
                      style: TextStyle(
                        fontSize: 25,
                      ),
                    ),
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class pagetwo extends StatelessWidget {
  late int food;
  late String img;
  String desc = ' ';
  pagetwo(int foood, String image) {
    food = foood;
    img = image;
  }
  void typefood() {
    if (food == 1) {
      desc = 'Peas\nMush Peas';
    } else if (food == 2) {
      desc = 'Multiple Ice\nOne Bowl\nPour ice and water in the bowl';
    } else if (food == 3) {
      desc = 'Beans\nToast\nPut toast on bed';
    } else {
      desc =
          'Two bread\nToast with lots of butter\nPut toast in between two breads';
    }
  }

  @override
  Widget build(BuildContext context) {
    typefood();
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(
            'This is the recipe',
          ),
          centerTitle: true,
        ),
        body: Column(
          children: [
            Container(
              child: Column(
                children: [
                  Container(
                    padding: EdgeInsets.all(12.0),
                    child: Image.network(img),
                    width: 250,
                    height: 250,
                  ),
                  Container(
                    child: Text(desc),
                  )
                ],
              ),
            ),
            Container()
          ],
        ),
      ),
    );
  }
}
