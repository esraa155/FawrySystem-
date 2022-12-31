package com.example.fawrysystem.Payment;

public class Overall extends Discount {

    double prec=10;
    public double pdisco_calcuay(double amount, double prec) {
        if(prec>1){
            prec/=100;
        }
        prec=0.1;
        amount = amount-(amount*prec);
        return amount;  }
    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }
}
