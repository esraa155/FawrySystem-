package com.example.fawrysystem.Refund;
import com.example.fawrysystem.UserAccount.Model.Receipt;

public abstract class Refund {
    public abstract Receipt requestRefund(String name, int id);

}
