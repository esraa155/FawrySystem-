package com.example.Fawrysystem.Service;

import com.example.Fawrysystem.Service.DonationProvider.DonationProvider;
import com.example.Fawrysystem.Service.DonationProvider.Hospital;
import com.example.Fawrysystem.Service.DonationProvider.NGO;
import com.example.Fawrysystem.Service.DonationProvider.School;

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
