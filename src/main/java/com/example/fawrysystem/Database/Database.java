package com.example.fawrysystem.Database;
import com.example.fawrysystem.Payment.Special;
import com.example.fawrysystem.Service.Service;
import com.example.fawrysystem.UserAccount.Model.Customer;
import com.example.fawrysystem.UserAccount.Model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static  List<Customer> customers  = new ArrayList<>();

    public static ArrayList<Service> services  = new ArrayList<Service>();
    public static ArrayList<Special> discount  = new ArrayList<Special>();
    public static ArrayList<String> servicesName  = new ArrayList<String>();
    public static ArrayList<Receipt> tr  = new ArrayList<Receipt>();
    Database(){

    }
}
