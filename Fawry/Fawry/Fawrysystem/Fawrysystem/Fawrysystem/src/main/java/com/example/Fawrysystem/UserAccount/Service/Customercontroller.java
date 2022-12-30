package com.example.Fawrysystem.UserAccount.Service;

import com.example.Fawrysystem.Database.Database;
import com.example.Fawrysystem.Payment.Special;
import com.example.Fawrysystem.Refund.Observer;
import com.example.Fawrysystem.UserAccount.Model.Customer;
import com.example.Fawrysystem.UserAccount.Model.Receipt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
@Service
@Component
  public class Customercontroller extends Account implements Observer {
    Scanner input = new Scanner(System.in);
    Customer customer = new Customer();
    AuthenticationManager authenticationManager;

    public void Customercontroller()  {}

    public String log_in(String username, String password) {
        for (int i = 0; i < Database.customers.size(); ++i) {
            if (Database.customers.get(i).getUsername().equals(username)) {
                if (Database.customers.get(i).getPassword().equals(password)) {
                    if (!Database.customers.get(i).isLoggedIn()) {
                        Database.customers.get(i).setLoggedIn(true);
                        return ("successful Logged in");
                    } else {
                        return ("you already Logged in");
                    }
                }
            }
        }
        return ("Wrong log in , Check username or Password");

    }
    public String Log_out(String username) {
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                int i=Database.customers.indexOf(customer);
                if(Database.customers.get(i).isLoggedIn()){
                    customer.setLoggedIn(false);

                    return ("Logged out");
                }
                else{
                    return ("already you logged out");
                }
            }
        }
        return ("Wrong logout !!");
    }




    public String sign_up(String email, String username, String password, String phonenumber,double amount) {
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                return  (" username already exits try again");

            }
        }
        Customer c = new Customer(email, username, password, phonenumber,amount);
        Database.customers.add(c);
        return  ("successful sign up");
    }
    
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
        boolean notF = false;
        for (Receipt r : Database.tr) {
            if (id == r.getId()) {
                r.setStatus("Waiting");
                int i = Database.tr.indexOf(r);
                Database.tr.set(i, r);
                notF = true;
                break;
            }
        }
        if (notF == false) {
            System.out.println("Not Fount");
        }
    }

    public void printrec(Customer s) {
        for (Receipt r : Database.tr) {
            if (s.getUsername() == r.getUsername()) {
                System.out.println("Receipt id : " + r.getId());
                System.out.println("Customer name : " + r.getUsername());
                System.out.println("Service name : " + r.getServiceName());
                System.out.println("Amount : " + r.getServicePrice());
                System.out.println("Statu : " + r.getStatus());
                System.out.println("==========================");
            }
        }
    }
    public void returnamount(double amount, Customer c) {
        for (int j = 0; j < Database.customers.size(); j++) {
            if (c.getUsername() == Database.customers.get(j).getUsername()) {
                c.setAmount(c.getAmount() + amount);
            }
        }
    }
}
