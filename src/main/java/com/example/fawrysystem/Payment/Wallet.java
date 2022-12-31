package com.example.fawrysystem.Payment;

import com.example.fawrysystem.Database.CustomerModel;
import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.UserAccount.Model.Customer;

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

    public String addwallet(String name, double amount) {
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
            CustomerModel.customers.get(i).setAmount(CustomerModel.customers.get(i).getAmount() + amount);
            return ("wallet Amount = " + CustomerModel.customers.get(i).getAmount());

        }
        return ("Wrong !!Check you login ");

    }
}
