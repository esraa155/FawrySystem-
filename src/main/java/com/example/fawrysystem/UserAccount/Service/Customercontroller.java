package com.example.fawrysystem.UserAccount.Service;

import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.Payment.Cash;
import com.example.fawrysystem.Payment.CreditCard;
import com.example.fawrysystem.Payment.Discount;
import com.example.fawrysystem.Payment.Overall;
import com.example.fawrysystem.Payment.Payment;
import com.example.fawrysystem.Payment.Special;
import com.example.fawrysystem.Payment.Wallet;
import com.example.fawrysystem.Refund.Observer;
import com.example.fawrysystem.Servicee.Donation;
import com.example.fawrysystem.Servicee.Internet;
import com.example.fawrysystem.Servicee.Landline;
import com.example.fawrysystem.Servicee.Mobile;
import com.example.fawrysystem.Servicee.Servicee;
import com.example.fawrysystem.UserAccount.Model.Customer;
import com.example.fawrysystem.UserAccount.Model.Receipt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Component
public class Customercontroller extends Account {
    Scanner input = new Scanner(System.in);
    Customer customer = new Customer();
    AuthenticationManager authenticationManager;

    public void Customercontroller() {
    }

    public String log_in(String username, String password) {
        int f = 5;
        for (int i = 0; i < Database.customers.size(); ++i) {
            if (Database.customers.get(i).getUsername().equals(username)) {
                if (Database.customers.get(i).getPassword().equals(password)) {
                    if (!Database.customers.get(i).isLoggedIn()) {
                        Database.customers.get(i).setLoggedIn(true);
                        f = 1;
                    } else {
                        f = 0;
                    }
                } else {
                    f = 2;
                }

            } else {
                f = 3;
            }
        }
        if (f == 0) {
            return ("already logged in");
        } else if (f == 1) {
            return ("successful login");
        } else if (f == 2) {
            return ("Wrong password");
        } else if (f == 3) {
            return ("Wrong user name");
        } else
            return ("Account Not Exist");

    }

    public String Log_out(String username) {
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                int i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    customer.setLoggedIn(false);
                    return ("Logged out");
                } else {
                    return ("already you logged out");
                }
            }
        }
        return ("Wrong logout !!");
    }

    public String sign_up(String email, String username, String password, String phonenumber, double amount) {
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                return (" username already exits try again");

            }
        }
        Customer c = new Customer(email, username, password, phonenumber, amount);
        Database.customers.add(c);
        return ("successful sign up");
    }

    public String addwallet(String name, double amount) {
        boolean f = false;
        int i = 0;
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(name)) {
                i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            Database.customers.get(i).setAmount(Database.customers.get(i).getAmount() + amount);
            return ("wallet Amount = " + Database.customers.get(i).getAmount());

        }
        return ("Wrong !!Check you login ");

    }

    public String search(String username, String sername) {
        Database.servicesName.add("Mobile");
        Database.servicesName.add("mobile");
        Database.servicesName.add("Internet");
        Database.servicesName.add("internet");
        Database.servicesName.add("Landline");
        Database.servicesName.add("landline");
        Database.servicesName.add("Donation");
        Database.servicesName.add("donation");
        boolean notF = false;
        boolean f = false;
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                int i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            for (String names : Database.servicesName) {
                if (names.contains(sername)) {
                    notF = true;
                }
            }
            if (notF == false) {
                System.out.println("Service " + sername + " is not Found");
            } else {
                return ("Service " + sername + " is Found");
            }
        } else {
            return ("wrong!!!");
        }
        return (" ");
    }

    public Discount[] checkDiscount(String username) {
        boolean f = false;
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(username)) {
                int i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            Discount[] d = new Discount[Database.discount.size()];
            for (int j = 0; j < Database.discount.size(); j++) {
                d[j] = Database.discount.get(j);
            }
            return d;
        } else
            return null;

    }

    public Receipt paymentway(String username, String sername, String prov, String payway, double amount) {
        boolean f = false;
        int i = 0;
        for (Customer custome : Database.customers) {
            if (custome.getUsername().equals(username)) {
                i = Database.customers.indexOf(custome);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            double dis = 0;
            Servicee ser;
            if (sername.equals("Internet")) {
                ser = new Internet();
                if (prov.equals("WEInternet")) {
                    ser.createProvider(1);
                } else if (prov.equals("VodafoneInternet")) {
                    ser.createProvider(2);
                } else if (prov.equals("EtisalatInternet")) {
                    ser.createProvider(3);
                } else if (prov.equals("OrangeInternet")) {
                    ser.createProvider(4);
                } else {
                    Receipt receipt = new Receipt(0, 0, 0 + "", " ", 0, " ", "error provider name", "", " ");
                    return receipt;
                }

            } else if (sername.equals("Mobile")) {
                ser = new Mobile();
                if (prov.equals("WEMobile")) {
                    ser.createProvider(1);
                } else if (prov.equals("VodafoneMobile")) {
                    ser.createProvider(2);
                } else if (prov.equals("EtisalatMobile")) {
                    ser.createProvider(3);
                } else if (prov.equals("OrangeMobile")) {
                    ser.createProvider(4);
                } else {
                    Receipt receipt = new Receipt(0, 0, 0 + " ", " ", 0, " ", "error provider name", "", " ");
                    return receipt;
                }
            } else if (sername.equals("Donation")) {
                ser = new Donation();
                if (prov.equals("NGO")) {
                    ser.createProvider(1);
                } else if (prov.equals("Hospital")) {
                    ser.createProvider(2);

                } else if (prov.equals("School")) {
                    ser.createProvider(3);
                } else {
                    Receipt receipt = new Receipt(0, 0, 0 + " ", "", 0, "", "error provider name", "", " ");
                    return receipt;
                }
            } else if (sername.equals("Landline")) {
                ser = new Landline();
                if (prov.equals("Quarter")) {
                    ser.createProvider(1);
                } else if (prov.equals("Monthly")) {
                    ser.createProvider(2);
                } else {
                    Receipt receipt = new Receipt(0, 0, 0 + " ", " ", 0, " ", "error provider name", "", " ");
                    return receipt;
                }

            } else {
                Receipt receipt = new Receipt(0, 0, 0 + " ", " ", 0, "error service name ", "", "", " ");
                return receipt;
            }

            if (Database.customers.get(i).isFrist()) {
                Discount d = new Overall();
                amount = d.pdisco_calcuay(amount, 10);
                dis = 10;
                Database.customers.get(i).setFrist(false);
            } else {
                for (Special s : Database.discount) {
                    if (prov.equals(s.getCompanyname())) {
                        dis = s.getPerc();
                        amount = s.pdisco_calcuay(amount, s.getPerc());
                    }
                }
            }
            if (payway.equals("cridetcard")) {
                Payment pay;
                pay = new CreditCard();
                pay.pay(Database.customers.get(i).getAmount(), amount);
                Database.customers.get(i).setAmount(pay.getAmount());
                Customer c = Database.customers.get(i);
                Database.customers.set(i, c);
            } else if (payway.equals("Wallet")) {
                Payment pay;
                pay = new Wallet();
                pay.pay(Database.customers.get(i).getAmount(), amount);
                Database.customers.get(i).setAmount(pay.getAmount());
                Customer c = Database.customers.get(i);
                Database.customers.set(i, c);
            } else if (payway.equals("Cash")) {
                Payment pay;
                pay = new Cash();
                pay.pay(Database.customers.get(i).getAmount(), amount);
                Database.customers.get(i).setAmount(pay.getAmount());
                Customer c = Database.customers.get(i);
                Database.customers.set(i, c);
            } else {
                Receipt receipt = new Receipt(0, 0, 0 + "", " ", 0, " ", "", "", "Error");
                return receipt;
            }
            Database.customers.get(i).setIdrec(Database.customers.get(i).getIdrec() + 1);
            Receipt receipt = new Receipt(amount, Database.customers.get(i).getAmount(), dis + "%",
                    Database.customers.get(i).getUsername(), Database.customers.get(i).getIdrec(), sername,
                    ser.getname(), "successful", payway);
            Database.tr.add(receipt);
            return receipt;
        }

        else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error in Customer", 0, " ", " ", "", "");
            return receipt;
        }
    }

    public Receipt requestRefund(String name, int id) {

        boolean f = false;
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(name)) {
                int i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            for (Receipt r : Database.tr) {
                if (id == r.getId()) {
                    r.setStatus("Waiting");
                    int i = Database.tr.indexOf(r);
                    Database.tr.set(i, r);
                    return r;
                }
            }
        } else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error Customer", 0, " ", " ", "", "");
            return receipt;
        }

        Receipt receipt = new Receipt(0, 0, 0 + "", "", 0, " ", " ", "NOT FOUND", "");
        return receipt;
    }

    public Receipt[] printrec(String name) {
        boolean f = false;
        for (Customer customer : Database.customers) {
            if (customer.getUsername().equals(name)) {
                int i = Database.customers.indexOf(customer);
                if (Database.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            int n = 0;
            for (int j = 0; j < Database.tr.size(); j++) {
                if (name.equals(Database.tr.get(j).getUsername()))
                    n += 1;
            }
            Receipt[] rec = new Receipt[n];
            for (int j = 0; j < Database.tr.size(); j++) {
                if (name.equals(Database.tr.get(j).getUsername()))
                    rec[j] = Database.tr.get(j);
            }
            return rec;

        } else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error Customer", 0, " ", " ", "", "");
            return new Receipt[] { receipt };
        }
    }

    public double returnamount(double amount, String c) {
        for (int j = 0; j < Database.customers.size(); j++) {
            if (c.equals(Database.customers.get(j).getUsername())) {
                Customer a = new Customer();
                a = Database.customers.get(j);
                a.setAmount(Database.customers.get(j).getAmount() + amount);
                Database.customers.set(j, a);
                return Database.customers.get(j).getAmount();
            }
        }
        return 0;
    }
}
