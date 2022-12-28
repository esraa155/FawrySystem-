import java.util.Scanner;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) {
    Customer Cu = new Customer("esraa@", "esraa", "123", "0111555");
    Customer Cust = new Customer("ibrahim@", "ibrahim", "12345", "0112345");
    Database.customers.add(Cust);
    Database.customers.add(Cu);
    Account a;
    Customer c=new Customer();
    Customer loggedInCustomer = new Customer();
    AuthenticationManager authenticate = AuthenticationManager.getInstance();
    Customercontroller customercontroller = new Customercontroller();
    Scanner input = new Scanner(System.in);
    int choice;
    int ch;
    int choose;
    String s;
    String d;
    
    System.out.println("=========================================================================================");
    System.out.println("the username of defult Customer  'ibrahim'   the password   '12345'");
    System.out.println("the username of defult Customer  'esraa'   the password   '123'");
    System.out.println("customer can search of services name like 'Mobile' & 'Internet'");
    System.out.println("the username of admin  'admin'   the password   'admin'");
    System.out.println("admin can add discount by name of services providers like 'WEMobile' & 'OrangeInternet'");
    System.out.println("==========================================================================================");
        
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
        	  authenticate = null;
            System.out.println("Logged In");
            System.out.println("========================================");
            while (true) {
              System.out.println("1/ choose services \n2/ serach of service name \n3/ checkDiscount \n4/ request refund \n5/ show me notification \n6/ logged out");
              ch = Integer.parseInt(input.nextLine());
              if (ch == 1) {
                while (true) {
                  System.out.println(
                      "1/ Mobile \n2/ Internet \n3/ Landline \n4/ Donation \n5/ exit for services");
                  int Option;
                  Option = Integer.parseInt(input.nextLine());
                  if (Option == 1) {
                	  System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
                      int opt;
                      opt = Integer.parseInt(input.nextLine());
                      Service mob = new Mobile();
                      mob.createProvider(opt);
                      paycontrol pay=new paycontrol();
                      pay.payform(loggedInCustomer,mob);
                    } else if (Option == 2) {
                      System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
                      int opt;
                      opt = Integer.parseInt(input.nextLine());
                      Service Inter = new Internet();
                      Inter.createProvider(opt);
                      paycontrol pay=new paycontrol();
                      pay.payform(loggedInCustomer,Inter);
                  } else if (Option == 3) {
                	  System.out.println("1/ WE   \n2/ Vodafone \n3/ Etisalat \n4/ Orange");
                      int opt;
                      opt = Integer.parseInt(input.nextLine());
                      Service Inter = new Internet();
                      Inter.createProvider(opt);
                      paycontrol pay=new paycontrol();
                      pay.payform(loggedInCustomer,Inter);
                  } else if (Option == 4) {
                	  System.out.println("1/NGO  \n2/Hospital \n3/School ");
                      int opt;
                      opt = Integer.parseInt(input.nextLine());
                      Service Doan = new Donation();
                      Doan.createProvider(opt);
                      paycontrol pay=new paycontrol();
                      pay.payform(loggedInCustomer,Doan);
                  } else if (Option == 5) {
                    System.out.println("ended services");
                    System.out.println("========================================");
                    break;
                  }
                  System.out.println("========================================");
                  continue;
                }
              } else if (ch == 2) {
            	  customercontroller.search();
              }
              else if(ch==3)
              {
            	  customercontroller.checkDiscount();
              }
              else if (ch == 4) {
            	  customercontroller.requestRefund(c.Id);
              }
              else if (ch == 5) {
            	  customercontroller.print(c.Id);
                }
              else if (ch == 6) {
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
          a = authenticate.getInstance();
          authenticate = (AuthenticationManager) a.log_in(username, password);
          if (authenticate != null) {
        	  loggedInCustomer = null;
            System.out.println("Logged In");
            while(true)
            {
            System.out.println("1 Add Discount \n2 show list of refund \n3 logout");
            System.out.println("========================================");
            choose = Integer.parseInt(input.nextLine());
              if (choose==1) {
            	  authenticate.addDiscount();
              }
              else if(choose==2){
            	  authenticate.listRefunds();
              }
              else if(choose==3){
                System.out.println(authenticate.Log_out());
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
          System.out.println("Amount you have : ");
          double amount =Double.parseDouble(input.nextLine()) ;
          loggedInCustomer = c.sign_up(email, username, password, phoneNumber,amount);
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
  
  private static void paycontrol(Customer a, Service doan) {
  }
  
}
