import java.util.ArrayList;

public class Customer extends Account implements Observer {

    private String email;
    private String username;
    private String password;
    private String phonenumber;
    private double amount;
    private boolean loggedIn = false;
    private CreditCard creditcard;

    public Customer() {
        email = "";
        username = "";
        password = "";
        phonenumber = "";
        amount = 1000.0;
        creditcard = null;
    }

	public Customer(String email, String username, String password, String phonenumber, double amount, boolean loggedIn, CreditCard creditcard) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.amount = amount;
		this.loggedIn = loggedIn;
		this.creditcard = creditcard;
	}

	//    public Customer(String email, String username, String password, String phonenumber) {
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.phonenumber = phonenumber;
//        this.amount = 1000.0;
//    }


    public Account log_in(String username, String password) {
        for (Customer customer : Database.customers) {
            if (customer.username.equals(username)) {
                if (customer.password.equals(password)) {
                    return customer;
                } else {
                    System.out.println("Check your password");
                    return null;
                }
            }
        }
        System.out.println("Your username is not found");
        return null;
    }

    public String Log_out() {
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(this.username)) {
                customer.setLoggedIn(false);
                return "Logged out";
            }
        }
        return "Error";
    }

    public Customer sign_up(String email, String username, String password, String phonenumber) {
        for (Customer customer : Database.customers) {
            if (customer.username.equals(username)) {
                System.out.println("This username already found");
                return null;
            }
        }
        Customer c = new Customer(email, username, password, phonenumber,amount,loggedIn,creditcard);
        c.type = "customer";
        c.loggedIn = true;
        Database.customers.add(c);
        return c;
    }

    public void search() {

    }

    public void checkDiscount() {

    }


    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public CreditCard getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}
}