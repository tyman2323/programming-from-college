//Ayman Tawaalai, 10-20-2021,balances of users, this program will generate accounts and return information on the avg, highest, and lowest balance
public class PayPalAccount {
	public double balance;//Attributes for the filler class
	public int accountid;
	public PayPalAccount(double x,int xx){//The constructors
	balance = x;
	accountid = xx;
	}
	public double balancegetter() {
		return balance;//Will return the balance when called upon by the bank
		
		
	}
	public int accountidgetter() {
		return accountid;//Will return the account id when called upon by the bank
	}
}