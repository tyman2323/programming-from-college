import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

void main() => runApp(theapp());

class theapp extends StatefulWidget {
  @override
  State<theapp> createState() => _theappState();
}

class _theappState extends State<theapp> {
  String overallnum = '';
  String displaynum =
      ''; //global variables that will be used to track numbers and if the enter button is pressed
  bool enterpressed = false;

  var listy = []; //inputs will be placed here
  Widget buttonformat(String buttonnum) {
    //widget will be used to create number buttons
    if (enterpressed == true) {
      return TextButton(
          onPressed:
              null, //if the enter button is pressed the buttons will become null untill clear is pressed
          child: Text(
            buttonnum,
            style: TextStyle(fontSize: 48),
          ));
    }
    return TextButton(
        style: TextButton.styleFrom(
            //displays the button with its respective number
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(160)),
            backgroundColor: Colors.black,
            padding: const EdgeInsets.all(10)),
        onPressed: () {
          overallnum += buttonnum;
          displaynum += buttonnum;
          setState(() {});
        },
        child: Text(
          buttonnum,
          style: TextStyle(fontSize: 48),
        ));
  }

  Widget cancelbutton(String cancel) {
    if (overallnum.isEmpty ||
        overallnum.endsWith('+') ||
        overallnum.endsWith('-') ||
        overallnum.endsWith('x') ||
        overallnum.endsWith('÷')) {
      //Implementation for how the cancel button will be used
      return TextButton(
          onPressed: null,
          child: Text(
            cancel,
            style: TextStyle(fontSize: 48),
          ));
    }
    return TextButton(
        style: TextButton.styleFrom(
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(160)),
            backgroundColor: Colors.black,
            padding: const EdgeInsets.all(10)),
        onPressed: () {
          overallnum = '';
          displaynum = '';
          listy.clear();
          enterpressed = false;

          setState(() {});
        },
        child: Text(
          cancel,
          style: TextStyle(fontSize: 48),
        ));
  }

  Widget logicbutton(String buttonnum) {
    //This widget will be the basis for math operation buttons
    if (overallnum.isEmpty ||
        overallnum.endsWith('+') ||
        overallnum.endsWith('-') ||
        overallnum.endsWith('x') ||
        overallnum.endsWith('÷') ||
        (enterpressed == true)) {
      return TextButton(
          onPressed: null,
          child: Text(
            buttonnum,
            style: TextStyle(fontSize: 48),
          ));
    }
    return TextButton(
        style: TextButton.styleFrom(
            shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(160)),
            backgroundColor: Colors.black,
            padding: const EdgeInsets.all(10)),
        onPressed: () {
          if (buttonnum == 'C') {
            overallnum = '';
            displaynum = '';
            listy.clear();
            //This ensures that the clear button wont become null so the user can still press it to do another calc
            enterpressed = false;
          } else {
            listy.add(int.parse(overallnum));
            listy.add(buttonnum);
            overallnum += buttonnum;
            displaynum += buttonnum;
            overallnum = '';
          }
          setState(() {});
        },
        child: Text(
          buttonnum,
          style: TextStyle(fontSize: 48),
        ));
  }

  Widget enterbutton(String enter) {
    if (overallnum.isEmpty ||
        overallnum.endsWith('+') ||
        overallnum.endsWith('-') ||
        overallnum.endsWith('x') ||
        overallnum.endsWith('÷') ||
        (enterpressed == true) ||
        listy.length < 2) {
      //Widget for the enter button
      return TextButton(
          style: TextButton.styleFrom(
              padding: EdgeInsets.all(1),
              backgroundColor: Colors.purple,
              minimumSize: const Size.fromHeight(1)),
          onPressed: null,
          child: Text(
            'Enter',
            style: TextStyle(fontSize: 50),
          ));
    }
    return TextButton(
      style: TextButton.styleFrom(
          padding: EdgeInsets.all(1),
          backgroundColor: Colors.purple,
          minimumSize: const Size.fromHeight(1)),
      onPressed: () {
        listy.add(int.parse(overallnum));
        enterpressed =
            true; //Calls upon the calculation method and will display the result
        int result = calculation();

        displaynum = listy[0].toString();

        setState(() {});
      },
      child: Text(
        'Enter',
        style: TextStyle(
          fontSize: 50,
        ),
      ),
    );
  }

  int calculation() {
    int thingy = 0;
    try {
      //Calculation that recursively goes through the list and returns the answer for th given mathematical input
      if (listy.contains('x') && listy.contains('÷')) {
        if (listy.indexOf('x') < listy.indexOf('÷')) {
          int product =
              listy[listy.indexOf('x') - 1] * listy[listy.indexOf('x') + 1];
          listy[listy.indexOf('x')] = product;
          listy.removeAt(listy.indexOf(product) - 1);
          listy.removeAt(listy.indexOf(product) + 1);
          print(listy);
          calculation();
        }
        if (listy.indexOf('x') > listy.indexOf('÷')) {
          var quotient =
              listy[listy.indexOf('÷') - 1] / listy[listy.indexOf('÷') + 1];
          int q = quotient.round();
          print(q);
          listy[listy.indexOf('÷')] = q;
          listy.removeAt(listy.indexOf(q) - 1);
          listy.removeAt(listy.indexOf(q) + 1);
          print(listy);
          calculation();
        }
      } else if (listy.contains('x')) {
        int product =
            listy[listy.indexOf('x') - 1] * listy[listy.indexOf('x') + 1];
        listy[listy.indexOf('x')] = product;
        listy.removeAt(listy.indexOf(product) - 1);
        listy.removeAt(listy.indexOf(product) + 1);
        print(listy);
        calculation();
      } else if (listy.contains('÷')) {
        var quotient =
            listy[listy.indexOf('÷') - 1] / listy[listy.indexOf('÷') + 1];
        int q = quotient.round();
        print(quotient);
        listy[listy.indexOf('÷')] = q;
        listy.removeAt(listy.indexOf(q) - 1);
        listy.removeAt(listy.indexOf(q) + 1);
        print(listy);
        calculation();
      } else if (listy.contains('+')) {
        int sum = listy[listy.indexOf('+') - 1] + listy[listy.indexOf('+') + 1];
        listy[listy.indexOf('+')] = sum;
        listy.removeAt(listy.indexOf(sum) - 1);
        listy.removeAt(listy.indexOf(sum) + 1);
        print(listy);
        calculation();
      } else if (listy.contains('-')) {
        int difference =
            listy[listy.indexOf('-') - 1] - listy[listy.indexOf('-') + 1];
        listy[listy.indexOf('-')] = difference;
        listy.removeAt(listy.indexOf(difference) - 1);
        listy.removeAt(listy.indexOf(difference) + 1);
        print(listy);
        calculation();
      }
      return thingy;
    } catch (exception) {
      return 5;
    }
  }

  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        appBar: AppBar(
          title: Text('All Results will be rounded'),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Container(
                        child: Text(
                      displaynum,
                      style: TextStyle(fontSize: 48, color: Colors.white),
                    )),
                  ],
                )),
            Row(mainAxisAlignment: MainAxisAlignment.center, children: [
              Container(
                padding: const EdgeInsets.all(8),
                child: logicbutton('+'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: logicbutton('-'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: logicbutton('x'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: logicbutton('÷'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: cancelbutton('C'),
              ),
            ]),
            Row(mainAxisAlignment: MainAxisAlignment.center, children: [
              Container(
                padding: const EdgeInsets.all(8),
                child: buttonformat('1'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: buttonformat('2'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: buttonformat('3'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: buttonformat('4'),
              ),
              Container(
                padding: const EdgeInsets.all(8),
                child: buttonformat('5'),
              )
            ]),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  padding: const EdgeInsets.all(8),
                  child: buttonformat('6'),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  child: buttonformat('7'),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  child: buttonformat('8'),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  child: buttonformat('9'),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  child: buttonformat('0'),
                )
              ],
            ),
            Container(
              child: enterbutton('enter'),
            )
          ],
        ),
      ),
    );
  }
}
