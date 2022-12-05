public class Cash implements Payment{
	 private  double payamount;

		public Cash() {
		}

		
	    public void setAmount(double amount) {
	        this.payamount = amount;
	    }

	    public double getAmount() {
	        return payamount;
	    }

	    public void pay(double customeramount,double payamount) {
	        System.out.println("Paying " + payamount + " using Cash.");
		   customeramount -= payamount;
	        System.out.print("amount :" + customeramount + "\n");

	    }

	
}
