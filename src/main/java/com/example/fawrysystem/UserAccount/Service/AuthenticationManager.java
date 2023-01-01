package com.example.fawrysystem.UserAccount.Service;
import com.example.fawrysystem.Database.*;
import com.example.fawrysystem.Payment.Special;
import com.example.fawrysystem.UserAccount.Model.*;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationManager extends Account {
    Admin admin = new Admin();
    public static AuthenticationManager instance = new AuthenticationManager();
    public static AuthenticationManager getInstance() {
        instance.admin.setusername("admin");
        instance.admin.setpassword("admin");
        instance.type = "admin";
        return instance;
    }

    public String log_in(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("admin")) {
            	if (!admin.isLoggedIn()) {
                 this.admin.setloggedIn(true);
                 return ("successful Logged in");
            	}
            	else
            	{
            	   return ("admin already logged in");
            	}
            }

            else {
                return ("Check Password and try again");
            }
        }
        return ("Check UserName and try again");
    }

    public String Log_out(String name) {
        if (admin.isLoggedIn()) {
            this.admin.setloggedIn(false);
            return ("successfully Logged out");
        } else {
            return ("Wrong logout and try again");
        }
    }
    public boolean addDiscount(String s, double p) {

        Special d = new Special();
        if (admin.isLoggedIn()) {
            if (d.add(s, p)) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Receipt[] printrecadmin() {
        if (admin.isLoggedIn()) {
            Receipt[] rec = new Receipt[ReceiptDB.tr.size()];
            for (int j = 0; j < ReceiptDB.tr.size(); j++) {
                rec[j] = ReceiptDB.tr.get(j);
            }
            return rec;
        }
        return null;
    }
    public Receipt[] Refundrec() {

            if (admin.isLoggedIn()) {
                Receipt[] rec = new Receipt[ReceiptDB.tr.size()];
                for (int j = 0; j < ReceiptDB.tr.size(); j++) {
                    if (ReceiptDB.tr.get(j).getStatus() == "Waiting")
                        rec[j] = ReceiptDB.tr.get(j);
                }
                return rec;
            }
            return null;
        }



    public Receipt actionRefunds(String s ,String action,int id ) {
        if (admin.isLoggedIn()){
            Receipt r=new Receipt();
            Customercontroller c1= new Customercontroller();
            for (int i=0;i<ReceiptDB.tr.size();i++){
                if (s.equals(ReceiptDB.tr.get(i).getUsername()) && id==ReceiptDB.tr.get(i).getId()&&ReceiptDB.tr.get(i).getStatus().equals("Waiting")){
                    switch (action) {
                        case "Accept":
                            r=ReceiptDB.tr.get(i);
                            r.setStatus("Accept refund");
                            r.setUserAmount( c1.returnamount(ReceiptDB.tr.get(i).getServicePrice(), s));
                            ReceiptDB.tr.set(i,r);
                            return r;
                        case "Refuse":
                            r=ReceiptDB.tr.get(i);

                            ReceiptDB.tr.get(i).setStatus("Refuse refund");
                            ReceiptDB.tr.set(i,r);
                            return r;
                    }

                }

            }
        }
        return null;

    }
    public addmoney[ ] Getaddmoney(){
        if (admin.isLoggedIn()) {
            addmoney[] ad = new addmoney[addmoneyDB.addmoney.size()];
            for (int j = 0; j < addmoneyDB.addmoney.size(); j++) {
    
                    ad[j] = addmoneyDB.addmoney.get(j);
            }
            return ad;
        }
        return null;
    
    }

}
