package com.example.fawrysystem.Payment;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.UserAccount.Model.Customer;

public class DiscountController {

    public Discount[] checkDiscount(String username) {
        boolean f = false;
        for (Customer customer : CustomerModel.customers) {
            if (customer.getUsername().equals(username)) {
                int i = CustomerModel.customers.indexOf(customer);
                if (CustomerModel.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            Discount[] d = new Discount[DiscountModel.discount.size()];
            for (int j = 0; j < DiscountModel.discount.size(); j++) {
                d[j] = DiscountModel.discount.get(j);
            }
            return d;
        } else
            return null;
    }

}
