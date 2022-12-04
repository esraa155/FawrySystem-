import java.util.ArrayList;

public class Customer extends Account implements Observer {

	private String email;
	   private String username;
	   private String password;
	   private String phonenumber;
	   private double amount;
	   private boolean loggedIn = false;
	   
	   public Customer() {
	     email = "";
	     username = "";
	     password = "";
	     phonenumber = "";
	     amount = 1000.0;
	   }
	   public Customer(String email, String username, String password, String phonenumber ) {
	     this.email = email;
	     this.username = username;
	     this.password = password;
	     this.phonenumber = phonenumber;
	     this.amount = 1000.0;
	   }
	public Account log_in(String username, String password) {
		 for(Customer customer : Database.customers) {
		       if (customer.username.equals(username)) { 
		        if(customer.password.equals(password)) {
		          return customer;
		        }else {
		          System.out.println( "Check your password");
		          return null;
		        }
		      }
		     }
		     System.out.println( "Your username is not found");
		return null;
	}

	public String Log_out() {
	for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(this.username)) {
                customer.setLoggedIn(false);
                return "Logged out";
            }
        }
		return null;
	}
	   public Customer sign_up(String email, String username, String password, String phonenumber) {
	        for (Customer customer : Database.customers) {
	            if (customer.username.equals(username)) {
	                System.out.println("This username already found");
	                return null;
	            }
	        }
	        Customer c = new Customer(email, username, password, phonenumber);
	        c.type = "customer";
	        c.loggedIn = true;
	        Database.customers.add(c);
	        return c;
	    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
