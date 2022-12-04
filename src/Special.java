public class Special implements Discount {
	private double perc=0.0;
	Payment pay;
    public double disco_calcu(double amount,double perc){
		pay.setAmount(amount);
		amount = amount*perc;
		
		
		return amount;
	}
    
    public void add(String n,double perc){
    	
    }
}
