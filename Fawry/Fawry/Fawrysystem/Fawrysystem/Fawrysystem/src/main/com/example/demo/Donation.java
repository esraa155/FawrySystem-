public class  Donation  implements Service{
	
	DonationProvider Dp;
	String name;

	public Donation() {
	}

	public void createProvider(int option) {
		if (option == 1) {
			Dp = (DonationProvider) new NGO();
		} else if (option == 2) {
			Dp = (DonationProvider) new Hospital();
		}

		else if (option == 3) {
			Dp = new School();
		}
		name = Dp.getname();
	}

	public String getname() {
		return name;
	}
		
}
