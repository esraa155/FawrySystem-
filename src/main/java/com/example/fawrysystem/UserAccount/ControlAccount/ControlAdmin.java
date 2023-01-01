package com.example.fawrysystem.UserAccount.ControlAccount;
import com.example.fawrysystem.UserAccount.Model.*;
import com.example.fawrysystem.UserAccount.Service.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")

public class ControlAdmin {
    @Autowired
    AuthenticationManager adminmanger = AuthenticationManager.getInstance();

    @PostMapping("/loginadmin")
    public String login(@RequestParam String name, @RequestParam String password) {
       return adminmanger.log_in(name, password);
    }
    @GetMapping("/logoutadmin")
      public String logout(){
       return adminmanger.Log_out("admin");

    }
    
    @PostMapping("/addDiscount")
    public String addDiscount(@RequestParam String Servicename, @RequestParam double Prec) {

        if (adminmanger.addDiscount(Servicename, Prec)) {
            return ("successfully added");
        } else {
            return ("Wrong added and try again");
        }
    }
    @GetMapping("/allreceipt")
    public Receipt[] Getreceipt(){
        return adminmanger.printrecadmin();
    }
    @GetMapping("/Refund")
    public Receipt[] Getrefund(){
        return adminmanger.Refundrec();
    }
    @PutMapping("/actionrefund")
    public Receipt actionrefund(@RequestParam String name,@RequestParam String action,@RequestParam int id){
        return adminmanger.actionRefunds(name,action,id);
    }
    @GetMapping("/addedmoney")
    public AddMoney[] added(){
        return adminmanger.Getaddmoney();
    }
}

