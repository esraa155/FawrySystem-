public class Cash extends Payment{
	 private double amount;

		public Cash(double amount) {
			this.amount = amount;
		}

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void pay(double paymentAmount) {
	        System.out.println("Paying " + paymentAmount + " using Cash.");
	        setAmount(getAmount() - paymentAmount);
	        System.out.print("amount :" + getAmount() + "\n");

	    }
}
