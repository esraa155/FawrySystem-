package com.example.Fawrysystem.Payment;

public interface Payment {
    public  void pay(double customeramount,double paymentAmount);

    public void setAmount(double amount);

    public  double getAmount();

}
