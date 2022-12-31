package com.example.fawrysystem.UserAccount.Service;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.Payment.*;
import com.example.fawrysystem.Refund.RefundConcrete;
import com.example.fawrysystem.UserAccount.Model.*;
import org.springframework.stereotype.*;

@Service
@Component
public class Customercontroller extends Account {
	
	public String log_in(String username, String password) {
        int f = 5;
        for (Customer c :CustomerModel.customers) {
            if (c.getUsername().equals(username)) {
                if (c.getPassword().equals(password)) {
                    if (!c.isLoggedIn()) {
                        c.setLoggedIn(true);
                        f = 1;
                        break;
                    } else {
                        f = 0;
                        break;
                    }
                } else {
                    f = 2;
                }

            } else {
                f = 3;
            }
        }
        if (f == 0) {
            return ("already logged in");
        } else if (f == 1) {
            return ("successful login");
        } else if (f == 2) {
            return ("Wrong password");
        } else if (f == 3) {
            return ("Wrong user name");
        } else return ("Account Not Exist");

    }

    public String Log_out(String username) {
        for (Customer customer : CustomerModel.customers) {
            if (customer.getUsername().equals(username)) {
                int i = CustomerModel.customers.indexOf(customer);
                if (CustomerModel.customers.get(i).isLoggedIn()) {
                    customer.setLoggedIn(false);
                    return ("successfully Logged out");
                } else {
                    return ("already you logged out");
                }
            }
        }
        return ("Wrong logout and try again");
    }

    public String sign_up(String email, String username, String password, String phonenumber, double amount) {
        for (Customer customer : CustomerModel.customers) {
            if (customer.getUsername().equals(username)) {
                return (" username already exits try again");
            }
        }
        Customer c = new Customer(email, username, password, phonenumber, amount);
        CustomerModel.customers.add(c);
        return ("successful sign up");
    }
     Wallet W=new Wallet();
    public addmoney addwallet(String name, double amount) {
       return W.addwallet(name,amount);
    }

    public String search(String username, String sername) {
        ServiceModel.servicesName.add("Mobile");
        ServiceModel.servicesName.add("mobile");
        ServiceModel.servicesName.add("Internet");
        ServiceModel.servicesName.add("internet");
        ServiceModel.servicesName.add("Landline");
        ServiceModel.servicesName.add("landline");
        ServiceModel.servicesName.add("Donation");
        ServiceModel.servicesName.add("donation");
        boolean notF = false;
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
            for (String names : ServiceModel.servicesName) {
                if (names.contains(sername)) {
                    notF = true;
                }
            }
            if (notF == false) {
                System.out.println("Service " + sername + " is not Found");
            } else {
                return ("Service " + sername + " is Found");
            }
        } else {
            return ("wrong and try again");
        }
        return (" ");
    }
    DiscountController DC=new DiscountController();
    public Discount[] checkDiscount(String username) {

         return  DC.checkDiscount(username);
    }
    PayController P=new PayController();
    public Receipt paymentway(String username, String sername, String prov, String payway, double amount) {
     return P.paymentway(username,sername,prov,payway,amount);
    }
    RefundConcrete R=new RefundConcrete();
    public Receipt requestRefund(String name, int id) {
            return R.requestRefund(name,id);
    }
    Receipt Re =new Receipt();
    public Receipt[] printrec(String name) {
         return Re.printrec(name);
    }
    public double returnamount(double amount, String c) {
        for (int j = 0; j < CustomerModel.customers.size(); j++) {
            if (c.equals(CustomerModel.customers.get(j).getUsername())) {
                Customer a = new Customer();
                a = CustomerModel.customers.get(j);
                a.setAmount(CustomerModel.customers.get(j).getAmount() + amount);
                CustomerModel.customers.set(j, a);
                return CustomerModel.customers.get(j).getAmount();
            }
        }
        return 0;
    }
}
