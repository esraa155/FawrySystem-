package com.example.fawrysystem.Refund;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.UserAccount.Model.*;

public class RefundConcrete extends Refund
{
    public Receipt requestRefund(String name, int id) {

        boolean f = false;
        for (Customer customer : CustomerDB.customers) {
            if (customer.getUsername().equals(name)) {
                int i = CustomerDB.customers.indexOf(customer);
                if (CustomerDB.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            for (Receipt r : ReceiptDB.tr) {
                if (id == r.getId()) {
                    r.setStatus("Waiting");
                    int i = ReceiptDB.tr.indexOf(r);
                    ReceiptDB.tr.set(i, r);
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


}

