package com.example.fawrysystem.UserAccount.Model;




public class Admin {
    String username;
    String password;
    String type;
    boolean loggedIn=false;

    public Admin() {	}


    public void setusername(String user_name)
    {
        this.username=user_name;
    }

    public void setpassword(String pass)
    {
        this.password=pass;
    }

    public void settype(String ty)
    {
        this.type=ty;
    }

    public void setloggedIn(boolean logged_in)
    {
        this.loggedIn=logged_in;
    }

    public String getusername()
    {
        return username;
    }

    public String getpassword()
    {
        return password;
    }

    public String gettype()
    {
        return type;
    }

    public boolean isLoggedIn()
    {
        return loggedIn;
    }
}
