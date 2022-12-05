import java.util.Scanner;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) {

	Service mobile = new Mobile();
    Service internet = new Internet();
    Service landline = new Landline();
    Service donation = new Donation();
    Database.services.add(mobile);
    Database.services.add(internet);
    Database.services.add(landline);
    Database.services.add(donation);
	Form f = new Form();
    ArrayList<String> servicesName = new ArrayList<String>();
    Customer Cu = new Customer("esraa@", "esraa", "123", "0111555");
    Database.customers.add(Cu);
    Account a;
    Customer c=new Customer();
    Customer loggedInCustomer = new Customer();
    Admin admin = Admin.getInstance();
    Scanner input = new Scanner(System.in);
    int choice;
		int ch;
		int choose;
		String s;
		String d;
		
		System.out.println("=========================================================");
		System.out.println("the username of Customer  'esraa'   the password   '123'");
        System.out.println("the username of admin  'admin'   the password   'admin'");
        System.out.println("=========================================================");
        
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
						while (true) {
							System.out.println("1/ choose services \n2/ serach of service name \n3/ checkDiscount \n4/ logout");
							ch = Integer.parseInt(input.nextLine());
							if (ch == 1) {
								while (true) {
									System.out.println(
											"1/ Mobile \n2/ Internet \n3/ Landline \n4/ Donation \n5/ exit for services");
									int Option;
									Option = Integer.parseInt(input.nextLine());
									f.createService(Option);
									if (Option == 1) {
										System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Mobile mob = new Mobile();
										mob.createProvider(opt,(Customer) a);

									} else if (Option == 2) {
										System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Internet Inter = new Internet();
										Inter.createProvider(opt,(Customer) a);
									} else if (Option == 3) {
										System.out.println("1/Quarterly   \n2/ Monthly ");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Landline land = new Landline();
										land.createProvider(opt,(Customer) a);
									} else if (Option == 4) {
										System.out.println("1/NGO  \n2/Hospital \n3/School ");
										int opt;
										opt = Integer.parseInt(input.nextLine());
										Donation Doan = new Donation();
										Doan.createProvider(opt,(Customer) a);
									} else if (Option == 5) {
										System.out.println("ended services");
										System.out.println("========================================");
										break;
									}
									System.out.println("========================================");
									continue;
								}
							} else if (ch == 2) {
									c.search();
							}
							else if(ch==3)
							{
								c.checkDiscount();
							}
							else if (ch == 4) {
								System.out.println(loggedInCustomer.Log_out());
								break;
							}
							System.out.println("========================================");
							continue;
						}
					}
					break;
				} else if (choice == 2) {
					System.out.println("Username : ");
					String username = input.nextLine();
					System.out.println("Password : ");
					String password = input.nextLine();
					a = Admin.getInstance();
					admin = (Admin) a.log_in(username, password);
					if (admin != null) {
						loggedInCustomer = null;
						System.out.println("Logged In");
						while(true)
						{
						System.out.println("1 Add Discount \n2 show list of refund \n3 logout");
						System.out.println("========================================");
						choose = Integer.parseInt(input.nextLine());
							if (choose==1) {
							  admin.addDiscount();
							}
							else if(choose==2){

							}
							else if(choose==3){
								System.out.println(a.Log_out());
								break;
							}
							System.out.println("========================================");
							continue;
					 	  }
						}
					 else {
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
