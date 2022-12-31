package com.example.fawrysystem.UserAccount.ControlAccount;


import com.example.fawrysystem.UserAccount.Model.Receipt;
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
            return ("added");
        } else {
            return ("Wrong added");
        }
    }
    @GetMapping("/allreceipt")
    public Receipt[] Getreceipt(){
        return adminmanger.printrec();
    }
    @GetMapping("/Refund")
    public Receipt[] Getrefund(){
        return adminmanger.Refundrec();
    }
}

