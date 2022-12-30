package com.example.Fawrysystem.Payment;

public class Overall extends Discount {
    public double pdisco_calcuay(double amount, double prec) {
        prec=0.1;
        amount = amount-(amount*prec);
        return amount;  }
}
