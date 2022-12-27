import java.util.ArrayList;
import java.util.Scanner;

public class AuthenticationManager extends Account {
	
	Admin admin = new Admin();
 
	protected ArrayList<Receipt> refundArr = new ArrayList<Receipt>();
    protected ArrayList<Receipt> accepted=new ArrayList<Receipt>();
    protected ArrayList<Receipt> refused=new ArrayList<Receipt>();
    public static AuthenticationManager instance = new AuthenticationManager();
    
    public static AuthenticationManager getInstance(){
		instance.admin.setusername("admin");
		instance.admin.setpassword("admin");
		instance.type = "admin";
		return instance;
	   }
	

	public Account log_in(String username, String password) {
		if(username.equals(this.admin.getusername())) {
			if(password.equals(this.admin.getpassword())) {
				this.admin.setloggedIn(true);
				return instance;
			}else {
				return null;
			}
		}
		return null;
	}	
	    public String Log_out(){
	    this.admin.setloggedIn(false);
		return "Logged Out";
	  }

	    public void addDiscount() {
	        Special d=new Special();
	        Scanner input = new Scanner(System.in);
	        System.out.println("Enter Service provider name");
	        String s = input.nextLine();
	        System.out.println("Enter percentage ");
	        double p = Integer.parseInt(input.nextLine());
	            d.add(s, p);
	      }
	    
        public void listRefunds() {
        	if(Database.refund.size()==0)
        		System.out.println("the list is empty");
        	Scanner Obj = new Scanner(System.in);
          for (int i = 0; i < Database.refund.size(); i++) {
              System.out.println(Database.refund.get(i).getServiceName());
              System.out.println(Database.refund.get(i).getServiceCode());
              System.out.println("1-Accept");
              System.out.println("2-Refuse");
              System.out.println("3-Ignore");
              int choice = Obj.nextInt();
              switch (choice) {
                  case 1:
                  Database.refund.get(i).setServiceStatus("Accepted");
                      accepted.add(Database.refund.get(i));
                      Database.refund.remove(i);
                      break;
                  case 2:
                  Database.refund.get(i).setServiceStatus("Refused");
                      refused.add(Database.refund.get(i));
                      Database.refund.remove(i);
                      break;
                  case 3:
                  Database.refund.get(i).setServiceStatus("Ignored");
                      Receipt temp = Database.refund.get(i);
                      Database.refund.remove(i);
                      Database.refund.add(temp);

                      break;
              }
          }
      }
        public void print(int id)
        {
        	for(int i =0; i<accepted.size(); i++)
        	{
        		if(id==accepted.get(i).userNum)
        		{
        			System.out.println(accepted.get(i).getServiceStatus()+"  ");
        			System.out.println(accepted.get(i).getServiceName()+"\n");
        		}
        	}
        	for(int i =0; i<refused.size(); i++)
        	{
        		if(id==refused.get(i).userNum)
        		{
        			System.out.println(refused.get(i).getServiceStatus()+"  ");
        			System.out.println(refused.get(i).getServiceName());
        		}
        	}
        }
}
