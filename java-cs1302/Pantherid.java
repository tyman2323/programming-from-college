package com.cs1302;
///////////////////////////////
//Name: Ayman Tawaalai	///////
// PantherID: 002-51-2578//////
///////////////////////////////





public class Pantherid {

	public static void main(String[] args) {
		int n = 78 ; //This line assigns the last to digits to the variable n
		if (n<10 || n>99) {//This will check if the digits placed are two digits and not more or less
			System.out.println("Incorrect value, please put the last two digits of your panther id");
			System.exit(0); //This will terminate the program
		}
		int m = n + 5; //This line adds the n with 5 to assign its value, 83, to m
		if (m%2!=0) { //An if statement is created to check whether is an odd number
		odd(m);	 //This will send the m value to the odd method
		}
		else { //The else is used for all last two digit numbers if they are even
			even(m); //This will send the m value to the even method
			
		}

	}
	public static void odd(int m) { //This is the odd method
		double q = 0; //The reason why  an empty q is created is to feed the for values into it
		for (double xx = 1; xx<= m; xx+=2) { //This for loop is created to go through all numbers, 1 through m that are odd, and add them to q to attain the expected output
			q = q + 1/xx; // This line will add the previous q with the needed division
			
			
		}
		System.out.println("The end result for the first is " + q);//This line will print out the output
		double zzz = 0; // This line creates and assigns 0 to our fill variable
		for(double zz = 3; zz<m;zz+=4) { // A loop is created to go through all numbers that add 4 from 3 up to m
			if( m == zz) { //This if statement is created to test whether or not zz is m to do the special calculation
				zzz = 2 * zz +1; //The special calculation as stated
			}
			else {// When zz is not m it will go through the non special equation
			zzz = zzz + 1/zz; //This is the non special equation
			}
		}
		System.out.println("The end result for the second is " + zzz); //This will print out the second equation's result
	}
	public static void even(int m) {
		double qq = 0; //The reason why  an empty qq is created is to feed the for values into it
		for (double qwe = 2; qwe<= m; qwe+=2) { //This for loop is created to go through all numbers, 2 through m that are even, and add them to q to attain the expected output
			qq = qq + 1/qwe; // This line will add the previous qq with the needed division
			
			
		}
		System.out.println("The end result is " + qq);//This line will print out the output
		double zzz = 0; // This line creates and assigns 0 to our fill variable
		for(double zz = 5; zz<m;zz+=6) { // A loop is created to go through all numbers that add 6 from 5 up to m
			if( m == zz) { //This if statement is created to test whether or not zz is m to do the special calculation
				zzz = 3 * zz -1; //The special calculation as stated
			}
			else {// When zz is not m it will go through the non special equation
			zzz = zzz + 1/zz; //The non special equation
			}
		}
		System.out.println("The end result for the second is " + zzz); // This will print out the second equation's result
	}

}
