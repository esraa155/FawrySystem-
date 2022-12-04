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
		return null;
	}
}
