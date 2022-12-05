public class Overall extends Discount {
	private double perc;
	Payment pay;
	Customer c;
    public double disco_calcu(Payment pay,double amount,double perc){
		pay.setAmount(amount);
		amount = amount-(amount*perc);
		return amount;
	}
    public Overall(Payment pay){
        super(pay);

    }
    @Override public void pay()
    {
        pay.pay(c.getAmount(),amount);
        disco_calcu(pay,pay.getAmount(), perc);
    }
    
}
