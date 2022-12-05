public class Donation  implements Service{
	DonationProvider Dp;
	Donation(){
	    
	}
	    public void createProvider(int option){
	        if(option == 1){
	            Dp = new NGO();
	        }
	        else if(option == 2){
	            Dp = new Hospital();
	        }
	        else if(option == 3){
	            Dp = new School();
	        }
	      
	    }
		public boolean contains(String name_) {
			// TODO Auto-generated method stub
			return false;
		}
}
