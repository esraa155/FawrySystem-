public class  Donation  implements Service{
	DonationProvider Dp;
	
	public Donation(){
	}
	    public void createProvider(int option,Customer c){
	        if(option == 1){
	            Dp = (DonationProvider) new NGO();
				Dp.getname();
				Dp.pay(c);
	        }
	        else if(option == 2){
	            Dp = (DonationProvider) new Hospital();
				Dp.getname();
				Dp.pay(c);
	        }
	        
	        else if(option == 3){
	            Dp = new School();
				Dp.getname();
				Dp.pay(c);
	        }
	      
	        
	    }
		
}
