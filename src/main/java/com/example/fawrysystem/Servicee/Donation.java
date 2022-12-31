package com.example.fawrysystem.Servicee;
import com.example.fawrysystem.Service.DonationProvider.*;

public class Donation implements Servicee {
    DonationProvider Dp;
    String name;

    public Donation() {
    }

    public void createProvider(int option) {
        if (option == 1) {
            Dp = new NGO();
        } else if (option == 2) {
            Dp =  new Hospital();
        }

        else if (option == 3) {
            Dp = new School();
        }
        name = Dp.getname();
    }

    public String getname() {
        return name;
    }
}