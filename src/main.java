import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
	Form f=new Form();
	ArrayList<String> servicesName  = new ArrayList<String>();
   Database. servicesName.add("Internet");
	Database.servicesName.add("Mobile");
	Database.servicesName.add("Landline");
	Database.servicesName.add("Donation");

	Account a;
	Customer c=new Customer();
	
	Admin m = null;
	Customer loggedInCustomer = new Customer();
	Admin admin = Admin.getInstance();
	Scanner input = new Scanner(System.in);
	int choice;
	int ch;
	String s;
	
	while (true) {
		System.out.println("Do you want to log in or sign up:");
		while (true) {
			System.out.println("1/ Log In As Customer \n2/ Log In As Admin\n3/ Sign Up \n4/ Exit");
			choice = Integer.parseInt(input.nextLine());
			if (choice == 1) {
				System.out.println("Username : ");
				String username = input.nextLine();
				System.out.println("Password : ");
				String password = input.nextLine();
				a = new Customer();
				loggedInCustomer = (Customer) a.log_in(username, password);
				if (loggedInCustomer != null) {
					admin = null;
					System.out.println("Logged In");
					System.out.println("========================================");
					while(true){
						System.out.println("1/ choice services \n2/ search of Services\n3/ logout");
						 ch = Integer.parseInt(input.nextLine());
						  if (ch == 1) 
						  {
							   while(true)
								{
								   System.out.println("1/ Mobile \n2/ Internet \n3/ Landline \n4/ Donation \n5/ exit for services");
								    int Option;
									Option = Integer.parseInt(input.nextLine());
									f.createService(Option);
									if(Option==1)
									{
										System.out.println("1/ WE \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Mobile mob=new Mobile();
										mob.createProvider(opt);
									 }
									 else if(Option==2)
									 {
										System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Internet Inter=new Internet();
										Inter.createProvider(opt);
									 }
									 else if(Option==3)
									 {
										System.out.println("1/Quarterly   \n2/ Monthly ");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Landline land=new Landline();
										land.createProvider(opt);
									 }
									 else if(Option==4){
										System.out.println("1/NGO  \n2/Hospital \n3/School ");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Donation Doan=new Donation();
										Doan.createProvider(opt);
									 }
									 else if(Option==5)
									 {
										System.out.println("ended services");
										break;
								     }
								  }
							  }
							  else if(ch==2) 
							  {
								c.search();
							}
							if (ch==3) 
							{
							   System.out.println(loggedInCustomer.Log_out());
								break;
							}
							System.out.println("========================================");
							continue;
				    } 
				} 
				break;
			}
			else if (choice == 2) {
				System.out.println("Username : ");
				String username = input.nextLine();
				System.out.println("Password : ");
				String password = input.nextLine();
				a = Admin.getInstance();
				admin = (Admin) a.log_in(username, password);
				if (admin != null) {
					loggedInCustomer = null;
					System.out.println("Logged In");
					System.out.println("========================================");
					System.out.println("Are you want to Logout yes/no");
					s = input.nextLine();
					if (loggedInCustomer != null) {
				        if (s.equals("yes")) {
							System.out.println(loggedInCustomer.Log_out());
						} 
					}
					
				} else {
					System.out.println("Your username or password is not correct");
					System.out.println("========================================");
					continue;
				}
				
				break;
			} else if (choice == 3) {
				System.out.println("Username : ");
				String username = input.nextLine();
				System.out.println("Password : ");
				String password = input.nextLine();
				System.out.println("Email : ");
				String email = input.nextLine();
				System.out.println("Phone Number : ");
				String phoneNumber = input.nextLine();
				c = new Customer();
				loggedInCustomer = c.sign_up(email, username, password, phoneNumber);
				if (loggedInCustomer != null) {
					System.out.println("Signed Up");
					System.out.println("========================================");
				} else {
					System.out.println("========================================");
					continue;
				}
				break;
			} else if (choice == 4) {
				break;
			} else {
				System.out.println("Input a valid number");
			}
		}
		if (choice == 4) {
			System.out.println("The system ended");
				break;
			}
		
	}

}
	}
