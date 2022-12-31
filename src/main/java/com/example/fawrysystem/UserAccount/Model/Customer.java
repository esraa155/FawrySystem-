package com.example.fawrysystem.UserAccount.Model;
import java.util.ArrayList;

public class Customer {

    protected static int Id=0;
    private String email;
    private String username;
    private String password;
    private String phonenumber;
    public double amount;
    public boolean loggedIn = false;
    private boolean frist = true;

    public static ArrayList<Receipt> tr  = new ArrayList<Receipt>();

    public Customer() {
        email="" ;
        username ="" ;
        password = "";
        phonenumber = "";
        amount =0;
        Id++;
    }



    public Customer(String email, String username, String password, String phonenumber, double amount) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.amount = amount;
        Id++;
    }
    public Customer(String email, String username, String password, String phonenumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.amount = 1000.0;
        Id++;
        loggedIn=true;
        frist=true;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public int getID() {
        return Id;
    }

    public boolean isFrist() {
        return frist;
    }

    public void setFrist(boolean frist) {
        this.frist = frist;
    }

    private  int idrec=0;
    public static ArrayList<Receipt> getTr() {
        return tr;
    }
    public static void setTr(ArrayList<Receipt> tr) {
        Customer.tr = tr;
    }
    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }
}

