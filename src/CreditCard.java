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

        System.out.println("Paying " + paymentAmount + " using Credit Card.");
        customeramount -= paymentAmount;
        System.out.print("amount :" + customeramount + "\n");
    }
}
