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
			 System.out.println("Paying " + paymentAmount + " using Wallet.");
			 customeramount -= paymentAmount;
			 System.out.print("amount :" +customeramount+"\n");
		}
}
