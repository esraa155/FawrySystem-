public class Wallet extends Payment{
	private double amount;
	
	Wallet(){
		this.amount=100000;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

		public double getAmount() {
			return amount;
		}

		public void pay(double paymentAmount) {
			 System.out.println("Paying " + paymentAmount + " using Wallet.");
	         setAmount(getAmount() - paymentAmount);
				System.out.print("amount :" +getAmount()+"\n");
		}
}
