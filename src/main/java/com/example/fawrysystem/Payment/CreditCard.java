package com.example.fawrysystem.Payment;

public class CreditCard implements Payment{
    private double amount;

    public CreditCard() {

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
}