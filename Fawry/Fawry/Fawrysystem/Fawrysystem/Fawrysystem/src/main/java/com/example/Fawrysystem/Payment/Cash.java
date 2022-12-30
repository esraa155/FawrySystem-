package com.example.Fawrysystem.Payment;

public class Cash implements Payment{
    private  double amount;

    public Cash() {
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void pay(double customeramount,double payamount) {
        if(payamount<0) {
            System.out.println("Invalid amount ");
        }
        else {
            System.out.println("Paying " + payamount + " using Cash.");
            if(customeramount<payamount) {
                System.out.println("Sorry, You do not have enough money.  ");
            }
            else {
                customeramount -= payamount;

                setAmount(customeramount);
                System.out.print("amount :" +amount+"\n");}
        }
    }
}
