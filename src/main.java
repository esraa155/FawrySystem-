import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Account a;
	Customer c;
	Admin m = null;
	Customer loggedInCustomer = new Customer();
	Admin admin = Admin.getInstance();
	Scanner input = new Scanner(System.in);
	int choice;
	
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
				} else {
					System.out.println("========================================");
					continue;
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
					System.out.println("========================================");
					
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
					System.out.println("Signed Up and Logged in");
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
