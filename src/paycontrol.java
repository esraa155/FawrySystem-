import java.util.Scanner;


public class paycontrol{


    public void payform(Customer c ,Service Ser) {
        String sername = Ser.getname();
    	System.out.println("welcome in Service to " + sername);
        Scanner input = new Scanner(System.in);
        Payment pay;
        int ch;
        System.out.print("Enter amount will paymant\n");
        double amount = Double.parseDouble(input.nextLine());
        for(Special s : Database.discount){
          
          if(sername.equals(s.getCompanyname())  ){
            amount= s.pdisco_calcuay(amount,s.getPerc());
            System.out.println("you have Discount  " + s.getPerc()*100+" %\n");
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
          pay.pay(c.getAmount(), amount);
          System.out.println("===================");
    
        }
        if (ch == 4) {
          System.out.println("The system ended");
          System.out.println("===================");
    
          
        }
        Receipt R=new Receipt( c.getAmount(), c.getID(),c.tr.size());
        Database.tr.add(R);
        c.tr.add(R);
      }
}
