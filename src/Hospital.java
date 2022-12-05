import java.util.Scanner;

public class Hospital implements DonationProvider {
  String name = "service for Hospital ";

   public void getname(){
       System.out.println(name);
   }
   public void pay() {
    Scanner input = new Scanner(System.in);
    Payment pay;
    int ch;
    System.out.print("Enter  Number Phone \n");
    String phone=input.nextLine();

    System.out.print("How want you will paymant ?\n1-creditcard\n2-wallet\n3-cach\n4-Exit\n");
    ch = Integer.parseInt(input.nextLine());
    if (ch == 1) {
      System.out.print("Enter amount will paymant\n");
      int amount = Integer.parseInt(input.nextLine());
      System.out.print("Enter the card number: ");
      String number = input.nextLine();
      System.out.print("Enter the CVV code: ");
      String cvv = input.nextLine();
      pay = new CreditCard(number, cvv);
      pay.pay(c.getAmount(), amount);
      System.out.println("===================");
    }
    if (ch == 2) {
      System.out.print("Enter amount will paymant ");
      int amount = Integer.parseInt(input.nextLine());
      pay = new Wallet();
      pay.pay(c.getAmount(), amount);
      System.out.println("===================");
    }
    if (ch == 3) {
      System.out.print("Enter amount will paymant ");
      int amount = Integer.parseInt(input.nextLine());
      pay = new Cash();
      // pay.setAmount(c.getAmount());
      pay.pay(c.getAmount(), amount);
      System.out.println("===================");
    }
    if (ch == 4) {
      System.out.println("The system ended");
      System.out.println("===================");
    }
  }
}
