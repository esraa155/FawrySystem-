public class CreditCard extends Payment{
	private double amount;
    private String number;
    private String cvv;

    public CreditCard(double amount, String number, String cvv) {
        this.amount = amount;
        this.number = number;
        this.cvv = cvv;
    }


    public CreditCard(String number, String cvv) {
        this.amount = 100000;
        this.number = number;
        this.cvv = cvv;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public void pay(double paymentAmount) {

        System.out.println("Paying " + paymentAmount + " using Credit Card.");
        setAmount(getAmount() - paymentAmount);
        System.out.print("amount :" + getAmount() + "\n");
    }
}
