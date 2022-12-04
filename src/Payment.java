public abstract class Payment {
	public double amount;

    public abstract void pay(double paymentAmount);

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
