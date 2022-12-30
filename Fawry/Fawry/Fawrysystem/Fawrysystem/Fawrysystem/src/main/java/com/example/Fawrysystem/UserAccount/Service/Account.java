package com.example.Fawrysystem.UserAccount.Service;

public abstract class Account {
    public String type;
    public abstract String log_in(String username , String password);
    public abstract String Log_out(String name);
}
