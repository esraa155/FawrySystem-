package com.example.fawrysystem.Payment;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.Servicee.*;
import com.example.fawrysystem.UserAccount.Model.*;

public class PayController {

    public Receipt paymentway(String username, String sername, String prov, String payway, double amount) {
        boolean f = false;
        int i = 0;
        for (Customer custome : CustomerModel.customers) {
            if (custome.getUsername().equals(username)) {
                i = CustomerModel.customers.indexOf(custome);
                if (CustomerModel.customers.get(i).isLoggedIn()) {
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

            if (CustomerModel.customers.get(i).isFrist()) {
                Discount d = new Overall();
                amount = d.pdisco_calcuay(amount, 10);
                dis = 10;
                CustomerModel.customers.get(i).setFrist(false);
            } else {
                for (Special s : DiscountModel.discount) {
                    if (prov.equals(s.getCompanyname())) {
                        dis = s.getPerc();
                        amount = s.pdisco_calcuay(amount, s.getPerc());
                    }
                }
            }
            if (payway.equals("cridetcard")) {
                Payment pay;
                pay = new CreditCard();
                pay.pay(CustomerModel.customers.get(i).getAmount(), amount);
                CustomerModel.customers.get(i).setAmount(pay.getAmount());
                Customer c = CustomerModel.customers.get(i);
                CustomerModel.customers.set(i, c);
            } else if (payway.equals("Wallet")) {
                Payment pay;
                pay = new Wallet();
                pay.pay(CustomerModel.customers.get(i).getAmount(), amount);
                CustomerModel.customers.get(i).setAmount(pay.getAmount());
                Customer c = CustomerModel.customers.get(i);
                CustomerModel.customers.set(i, c);
            } else if (payway.equals("Cash")) {
                Payment pay;
                pay = new Cash();
                pay.pay(CustomerModel.customers.get(i).getAmount(), amount);
                CustomerModel.customers.get(i).setAmount(pay.getAmount());
                Customer c = CustomerModel.customers.get(i);
                CustomerModel.customers.set(i, c);
            } else {
                Receipt receipt = new Receipt(0, 0, 0 + "", " ", 0, " ", "", "", "Error");
                return receipt;
            }
            CustomerModel.customers.get(i).setIdrec(CustomerModel.customers.get(i).getIdrec() + 1);
            Receipt receipt = new Receipt(amount, CustomerModel.customers.get(i).getAmount(), dis + "%",
                    CustomerModel.customers.get(i).getUsername(), CustomerModel.customers.get(i).getIdrec(), sername,
                    ser.getname(), "successful", payway);
            ReceiptModel.tr.add(receipt);
            return receipt;
        }

        else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error in Customer", 0, " ", " ", "", "");
            return receipt;
        }
    }

}
