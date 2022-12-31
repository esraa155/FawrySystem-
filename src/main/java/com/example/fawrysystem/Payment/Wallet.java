package com.example.fawrysystem.Payment;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.Database.addmoneyDb;
import com.example.fawrysystem.UserAccount.Model.*;

    public class Wallet implements Payment{
    private double amount;
    public Wallet(){
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public void pay(double customeramount,double paymentAmount) {
            customeramount -= paymentAmount;
            setAmount(customeramount);
        }

        public addmoney addwallet(String name, double amount) {
            boolean f = false;
            int i = 0;
            for (Customer customer : CustomerModel.customers) {
                if (customer.getUsername().equals(name)) {
                    i = CustomerModel.customers.indexOf(customer);
                    if (CustomerModel.customers.get(i).isLoggedIn()) {
                        f = true;
                    }
                }
            }
            if (f) {
                double n=CustomerModel.customers.get(i).getAmount() + amount;
                CustomerModel.customers.get(i).setAmount(n);
                addmoney e= new addmoney(name,n,amount);
                  addmoneyDb.addmoney.add(e);
                   return e;
            }
            return  null;
        }
}
