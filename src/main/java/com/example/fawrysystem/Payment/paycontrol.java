package com.example.fawrysystem.Payment;

import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.Service.Service;
import com.example.fawrysystem.UserAccount.Model.Customer;
import com.example.fawrysystem.UserAccount.Model.Receipt;

import java.util.Scanner;

public class paycontrol {
    public void payform(Customer c, Service Ser) {

        if (c.isLoggedIn()) {
            System.out.println("Hallo , " + c.getUsername());
            String sername = Ser.getname();
            System.out.println("welcome in Service to " + sername);
            Scanner input = new Scanner(System.in);
            Payment pay;
            int ch;
            System.out.print("Enter amount will paymant\n");
            double amount = Double.parseDouble(input.nextLine());

            if (c.isFrist()) {
                Overall O = new Overall();
                amount = O.pdisco_calcuay(amount, 0.1);
                System.out.println("you have Frist time Discount  " + 10 + " %\n");
                c.setFrist(false);
                for (int i = 0; i < Database.customers.size(); i++) {
                    if (c.getUsername().equals(Database.customers.get(i).getUsername())) {
                        Database.customers.set(i, c);
                    }

                }

            } else {
                for (Special s : Database.discount) {
                    if (sername.equals(s.getCompanyname())) {
                        amount = s.pdisco_calcuay(amount, s.getPerc());
                        System.out.println("you have Discount  " + s.getPerc() * 100 + " %\n");
                    }
                }
            }
            System.out.print("How want you will paymant ?\n1-creditcard\n2-wallet\n3-cach\n4-Exit\n");
            ch = Integer.parseInt(input.nextLine());
            if (ch == 1) {
                for (int i = 0; i < Database.customers.size(); i++) {

                    if (c.getUsername().equals(Database.customers.get(i).getUsername())) {

                        System.out.print("Enter the card number: ");
                        String number = input.nextLine();
                        System.out.print("Enter the CVV code: ");
                        String cvv = input.nextLine();
                        pay = new CreditCard(number, cvv);
                        pay.pay(c.getAmount(), amount);
                        c.setAmount(pay.getAmount());
                        Database.customers.set(i, c);
                        System.out.println("===================");
                    }
                }

            }
            if (ch == 2) {
                for (int i = 0; i < Database.customers.size(); i++) {
                    if (c.getUsername().equals(Database.customers.get(i).getUsername())) {
                        pay = new Wallet();
                        pay.pay(c.getAmount(), amount);
                        c.setAmount(pay.getAmount());
                        Database.customers.set(i, c);
                    }

                }
                System.out.println("===================");

            }
            if (ch == 3) {

                for (int i = 0; i < Database.customers.size(); i++) {
                    if (c.getUsername().equals(Database.customers.get(i).getUsername())) {
                        pay = new Cash();
                        pay.pay(c.getAmount(), amount);
                        c.setAmount(pay.getAmount());
                        Database.customers.set(i, c);
                    }

                }

            }
            c.setIdrec(c.getIdrec()+1);
            Receipt receipt = new Receipt(amount,c.getUsername(),c.getIdrec(),sername,"Successful");
            Database.tr.add(receipt);
            if (ch == 4) {
                System.out.println("The system ended");
                System.out.println("===================");
            }

        }
    }
}
