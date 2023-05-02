//Ayman Tawaalai, 10-20-2021,balances of users, this program will generate accounts and return information on the avg, highest, and lowest balance


import java.util.Scanner;
public class Bank {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//The scanner is used to know how many accounts must be generated
		System.out.println("How many accounts?");
		int numOfAccounts = input.nextInt();
		PayPalAccount[] PayPalAray = new PayPalAccount[numOfAccounts];//Creates an array with the ammount of elements set by the user for each account
		for(int j = 0;j<numOfAccounts;j++) {
			double balancee = Math.random()*1001;
			PayPalAray[j] = new PayPalAccount(balancee,j);//The loop fills the account with data
			
		}
		int k = 0;
      int counter = 0;
		while(k<PayPalAray.length) {//This while loop will go through all the elements and see if my id is in the array
			if(PayPalAray[k].accountidgetter() == 002) {
				k =1002;
			}
			else {
				k++;
            counter++;
			}
		}
		if(k==PayPalAray.length) {//This will ensure that if my id is not in the array then it wil replace the last account for mine, and transfer the moeny out of the first account into my account
         double samebal = PayPalAray[0].balancegetter();
			PayPalAray[numOfAccounts] = new PayPalAccount(samebal,2);
         PayPalAray[0] = new PayPalAccount(0,0);
         System.out.println("My panther ID is ; my back account ID is " + PayPalAray[numOfAccounts].accountidgetter() + " and the balance is" + PayPalAray[numOfAccounts].balancegetter()); 
		}
      else{//This is used when my id is within the array already
         PayPalAray[counter] = new PayPalAccount(125.78,counter);
         System.out.println("My panther ID is ; my back account ID is " + PayPalAray[counter].accountidgetter() + " and the balance is" + PayPalAray[counter].balancegetter()); 

	}
      int total = 0;
      double large = 0;
      int larg =0;
      double small = 999999999;
      int smal = 0;
      for(int j = 0;j<numOfAccounts;j++) {//This loop is used to get the total amount of balances
			total+=PayPalAray[j].balancegetter();	
		}
      double avg = total/numOfAccounts;//This will divide by the total elements for an average
      System.out.println("The average balance is" + total);
            for(int j = 0;j<numOfAccounts;j++) {
			if(large<PayPalAray[j].balancegetter()){//This loop will go through each element in the array to find the largest 
            large = PayPalAray[j].balancegetter();
            larg = PayPalAray[j].accountidgetter();
         }	
		}
      System.out.println("The account with the largets balance: account id = " + PayPalAray[larg].accountidgetter() + " balance = " + large);
         for(int j = 0;j<numOfAccounts;j++) {
			if(small>PayPalAray[j].balancegetter()){//This loop will go through each element in the array to find the smallest balance
            small = PayPalAray[j].balancegetter();
            smal = PayPalAray[j].accountidgetter();
         }	
		}
      System.out.println("The account with the largets balance: account id = " + PayPalAray[smal].accountidgetter() + " balance = " + small);


   }
}



