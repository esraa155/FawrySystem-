import java.util.Scanner;

public class Customercontroller  implements Observer {
    
	Scanner input = new Scanner(System.in);
	Customer customer = new Customer();
	
	public Customercontroller() {}
	

	    public void search() {

	     Database.servicesName.add("Mobile");
	     Database.servicesName.add("mobile");
	     Database.servicesName.add("Internet");
	     Database. servicesName.add("internet");
	     Database.servicesName.add("Landline");
	     Database. servicesName.add("landline");
	     Database. servicesName.add("Donation");
	     Database. servicesName.add("donation");
	     System.out.println("Enter Service name you want ");
	     String name = input.nextLine();
	     boolean notF = false;
	     for (String names :Database.servicesName) {
	     if (names.contains(name)) {
	     System.out.println("Service " + name + " is Found");
	     notF = true;
	     break;
	       }
	     }
	     if (notF == false) {
	        System.out.println("Service " + name + " is not Found");
	     }
	    
	}


	    public void checkDiscount() {
	    	for(Special s:Database.discount){
	    	    System.out.println("available Discount in "+s.getCompanyname()+" and percentage "+s.getPerc()*100+"%");
	    	}
	    }
	    
	      
	        public void requestRefund(int id) {
	    	Scanner myObj = new Scanner(System.in);
	        String code, name;
	        double price;
	        System.out.println("Enter Name of service:");
	        name = myObj.next();
	        System.out.println("Enter code number of operation:");
	        code = myObj.next();
	        System.out.println("Enter price odf service:");
	        price = myObj.nextDouble();
	        Receipt R = new Receipt(price, customer.getID(),id,name,code);
	        Database.refund.add(R);
	    }

	    
	 
}
