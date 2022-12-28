public class CreditCard implements Payment{
	private double amount;
    private String number;
    private String cvv;

    
    public CreditCard(double amount, String number, String cvv) {
        this.amount = amount;
        this.number = number;
        this.cvv = cvv;
    }


    public CreditCard(String number, String cvv) {
        this.number = number;
        this.cvv = cvv;
    }

    public CreditCard(int i, int j) {
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
		 System.out.println("Paying " + paymentAmount + " using Cridtcard.");
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
