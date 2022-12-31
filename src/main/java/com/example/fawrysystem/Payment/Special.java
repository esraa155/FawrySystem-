package com.example.fawrysystem.Payment;

import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.UserAccount.Model.Customer;

public class Special extends Discount{
    private String companyname;
    private double perc;


    public Special() {
    }

    public Special(String n, double perc2) {
        this.companyname=n;
        this.perc=perc2;
    }

    public boolean add(String n,double perc){
        Special s =new Special(n,perc);
        Database.discount.add(s);
        return true;
    }

    @Override
    public double pdisco_calcuay(double amount, double prec) {
        if(perc>1){
            perc/=100;
        }
        amount = amount-(amount*perc);
        return amount;
    }
    public double getPerc() {
        return perc;
    }
    public void setPerc(double perc) {
        this.perc = perc;
    }
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
