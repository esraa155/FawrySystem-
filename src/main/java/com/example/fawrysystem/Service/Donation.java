package com.example.fawrysystem.Service;

import com.example.fawrysystem.Service.DonationProvider.DonationProvider;
import com.example.fawrysystem.Service.DonationProvider.Hospital;
import com.example.fawrysystem.Service.DonationProvider.NGO;
import com.example.fawrysystem.Service.DonationProvider.School;

public class Donation implements Service{
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
