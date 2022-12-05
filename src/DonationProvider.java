public class DonationProvider {
	DonationProvider(){
		
	}
	Hospital H;
    NGO N;
	School S;
    public void createProvider(int option){
        if(option == 1){
            H = new Hospital();
        }
        else if(option == 2){
            N = new NGO();
        }
		else if(option==3)
      {
		S = new School();
	  }
    }
}
