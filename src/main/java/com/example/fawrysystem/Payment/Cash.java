package com.example.fawrysystem.Payment;

public class Cash implements Payment {
    private double amount;

    public Cash() {
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void pay(double customeramount, double payamount) {
        customeramount -= payamount;
        setAmount(customeramount);
    }
}