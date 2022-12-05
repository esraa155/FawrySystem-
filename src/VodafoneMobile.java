import java.util.Scanner;

public class VodafoneMobile extends Vodafone {

    String name ="service for Vodafone Mobile ";

    public void getname(){
        System.out.println(name);
    }
    
    public void pay(Customer c ) {
        
        Scanner input = new Scanner(System.in);
        Payment pay;
        int ch;
        System.out.print("Enter amount will paymant\n");
        double amount = Double.parseDouble(input.nextLine());
        for(Special s : Database.discount){
          String n="VodafoneMobile",a="Vodafonmobile";
          if(n.equals(s.getCompanyname()) ||a.equals(s.getCompanyname()) ){
            amount= s.pdisco_calcuay(amount,s.getPerc());
            System.out.println("you have Discount" + s.getPerc()*100+" %\n");
          }
        }
        System.out.print("How want you will paymant ?\n1-creditcard\n2-wallet\n3-cach\n4-Exit\n");
        ch = Integer.parseInt(input.nextLine());
        if (ch == 1) {
          System.out.print("Enter the card number: ");
          String number = input.nextLine();
          System.out.print("Enter the CVV code: ");
          String cvv = input.nextLine();
          pay = new CreditCard(number, cvv);
          pay.pay(c.getAmount(), amount);
          System.out.println("===================");
    
        }
        if (ch == 2) {
         
          pay = new Wallet();
          pay.pay(c.getAmount(), amount);
          System.out.println("===================");
    
        }
        if (ch == 3) {
    
         
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
