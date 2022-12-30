package com.example.fawrysystem.UserAccount.ControlAccount;
import com.example.fawrysystem.UserAccount.Service.Customercontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Customer")

public class Controlcoustomer {
    @Autowired
    Customercontroller Customercontroller=new Customercontroller();

    @PostMapping("/signup")
    public String signup(@RequestParam String email, @RequestParam String name , @RequestParam String password , @RequestParam String phonenumber, @RequestParam double amount) {
     return  Customercontroller.sign_up(email,name, password,phonenumber,amount);
    }
    @PostMapping("/logincustomer")
    public String login(@RequestParam String name, @RequestParam String password) {
       return Customercontroller.log_in(name, password);
    }
    @PostMapping("/logoutcustomer")
      public String logout(@RequestParam String name){
        return Customercontroller.Log_out(name);
    }


}
