public class Special extends Discount {
	private double perc;
	Payment pay;
	Customer c;
	private String companyname;
    public double disco_calcu(Payment pay,double amount,double perc){
		pay.setAmount(amount);
		amount = amount-(amount*perc);
		return amount;
	}
    public Special(Payment pay){
        super(pay);

    }
    @Override public void pay()
    {
        pay.pay(c.getAmount(),amount);
        disco_calcu(pay,pay.getAmount(), perc);
    }
    
    
    public void add(String n,double perc){
    	this.disco_calcu(pay,pay.getAmount(), perc);
    }

}
