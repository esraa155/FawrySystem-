package com.example.fawrysystem.UserAccount.Service;

import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.Payment.Special;
import com.example.fawrysystem.UserAccount.Model.Admin;
import com.example.fawrysystem.UserAccount.Model.Customer;
import com.example.fawrysystem.UserAccount.Model.Receipt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service

public class AuthenticationManager extends Account {
    Admin admin = new Admin();
    protected ArrayList<Receipt> refundArr = new ArrayList<Receipt>();
    protected ArrayList<Receipt> accepted = new ArrayList<Receipt>();
    protected ArrayList<Receipt> refused = new ArrayList<Receipt>();
    public static AuthenticationManager instance = new AuthenticationManager();
    Customercontroller customercontroller = new Customercontroller();
    protected double newamount;

    public static AuthenticationManager getInstance() {
        instance.admin.setusername("admin");
        instance.admin.setpassword("admin");
        instance.type = "admin";
        return instance;
    }

    public String log_in(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("admin")) {
                this.admin.setloggedIn(true);
                return ("successful Logged in");
            }

            else {
                return ("Check Password");
            }
        }
        return ("Check UserName or Password");
    }

    public String Log_out(String name) {
        if (admin.isLoggedIn()) {
            this.admin.setloggedIn(false);
            return ("Logged out");
        } else {
            return ("Wrong logout !!");
        }
    }

    public boolean addDiscount(String s, double p) {
        Special d = new Special();
        if (admin.isLoggedIn()) {
            if (d.add(s, p)) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Receipt[] printrec() {
        if (admin.isLoggedIn()) {
            Receipt[] rec = new Receipt[Database.tr.size()];
            for (int j = 0; j < Database.tr.size(); j++) {
                rec[j] = Database.tr.get(j);
            }
            return rec;
        }
        return null;
    }

    public Receipt[] Refundrec() {
        if (admin.isLoggedIn()) {
            Receipt[] rec = new Receipt[Database.tr.size()];
            for (int j = 0; j < Database.tr.size(); j++) {
                if (Database.tr.get(j).getStatus() == "Waiting")
                rec[j] = Database.tr.get(j);
            }
            return rec;
        }
        return null;
    }
}
