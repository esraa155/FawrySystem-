package com.example.fawrysystem.UserAccount.Model;

public class addmoney {
	
    private String Uesrname;
    private double Usermoney;
    private double Addmoney;

    public addmoney(String uesrname, double usermoney, double addmoney) {
        this.Uesrname = uesrname;
        this.Usermoney = usermoney;
        this.Addmoney = addmoney;
    }

    public String getUesrname() {
        return Uesrname;
    }

    public void setUesrname(String uesrname) {
        Uesrname = uesrname;
    }

    public double getUsermoney() {
        return Usermoney;
    }

    public void setUsermoney(double usermoney) {
        Usermoney = usermoney;
    }

    public double getAddmoney() {
        return Addmoney;
    }

    public void setAddmoney(double addmoney) {
        Addmoney = addmoney;
    }

}
