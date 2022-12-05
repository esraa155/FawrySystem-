public class Admin extends Account {

	String username;
	String password;
	String type;
	boolean loggedIn = false;
	public Special discount=null;
	public static Admin instance = new Admin();
	
	private Admin() {	}
	public static Admin getInstance(){
		instance.username = "admin";
		instance.password = "admin";
		instance.type = "admin";
		return instance;
	   }
	
	public Account log_in(String username, String password) {
		if(username.equals(this.username)) {
			if(password.equals(this.password)) {
				this.loggedIn = true;
				return instance;
			}else {
				return null;
			}
		}
		return null;
	}	
	    public String Log_out(){
	    this.loggedIn = false;
		System.out.println("Logged Out");
		return "Logged Out";
	  }

	    public void addDiscount(String s,double perc) {
			 discount.add(s,perc);
		}
	 
	  
	}


