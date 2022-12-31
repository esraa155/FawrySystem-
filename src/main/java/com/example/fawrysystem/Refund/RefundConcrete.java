package com.example.fawrysystem.Refund;

import com.example.fawrysystem.Database.CustomerModel;
import com.example.fawrysystem.Database.Database;
import com.example.fawrysystem.Database.ReceiptModel;
import com.example.fawrysystem.UserAccount.Model.Admin;
import com.example.fawrysystem.UserAccount.Model.Customer;
import com.example.fawrysystem.UserAccount.Model.Receipt;
import com.example.fawrysystem.UserAccount.Service.Customercontroller;

public class RefundConcrete extends Refund
{
    public Receipt requestRefund(String name, int id) {

        boolean f = false;
        for (Customer customer : CustomerModel.customers) {
            if (customer.getUsername().equals(name)) {
                int i = CustomerModel.customers.indexOf(customer);
                if (CustomerModel.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            for (Receipt r : ReceiptModel.tr) {
                if (id == r.getId()) {
                    r.setStatus("Waiting");
                    int i = ReceiptModel.tr.indexOf(r);
                    ReceiptModel.tr.set(i, r);
                    return r;
                }
            }
        } else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error Customer", 0, " ", " ", "", "");
            return receipt;
        }

        Receipt receipt = new Receipt(0, 0, 0 + "", "", 0, " ", " ", "NOT FOUND", "");
        return receipt;
    }

    Admin admin = new Admin();




}

