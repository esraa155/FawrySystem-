package com.example.fawrysystem.Payment;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.UserAccount.Model.Customer;

public class DiscountController {

    public Discount[] checkDiscount(String username) {
        boolean f = false;
        for (Customer customer : CustomerDB.customers) {
            if (customer.getUsername().equals(username)) {
                int i = CustomerDB.customers.indexOf(customer);
                if (CustomerDB.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            Discount[] d = new Discount[DiscountDB.discount.size()];
            for (int j = 0; j < DiscountDB.discount.size(); j++) {
                d[j] = DiscountDB.discount.get(j);
            }
            return d;
        } else
            return null;
    }

}
