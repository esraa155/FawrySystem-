public class Wallet implements Payment{
	private double amount;
	Wallet(){
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

		public double getAmount() {
			return amount;
		}
		

		public void pay(double customeramount,double paymentAmount) {
			if(paymentAmount<0) {
				 System.out.println("Invalid amount ");
			}
			else {
			 System.out.println("Paying " + paymentAmount + " using Wallet.");
			 if(customeramount<paymentAmount) {
				 System.out.println("Sorry, You do not have enough money.  ");
			}
			else {
				 customeramount -= paymentAmount;

			 setAmount(customeramount);
			 System.out.print("amount :" +amount+"\n");}
		}
}
}