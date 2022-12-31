package com.example.fawrysystem.UserAccount.ControlAccount;
import com.example.fawrysystem.Payment.Discount;
import com.example.fawrysystem.UserAccount.Model.Receipt;
import com.example.fawrysystem.UserAccount.Model.addmoney;
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
    @GetMapping("/Sreach")
    public String Sreach(@RequestParam String name , @RequestParam String sername){
     return Customercontroller.search(name,sername);
    }

    @GetMapping("/GetDiscount")
    public Discount[] getdiscount(@RequestParam String name){
        return Customercontroller.checkDiscount(name);
    }

    @GetMapping("/Service/{sername}/Provider/{prov}/Paymentway/{payway}")
     public Receipt payment(@RequestParam String name,@PathVariable("sername") String sername,@PathVariable("prov") String prov,@PathVariable("payway") String payway,@RequestParam double amount ){
        return Customercontroller.paymentway(name,sername,prov,payway,amount);
        ///Service/Internet/Provider/WEInternet/Payment way/Wallet
    }

    @PutMapping("/Sendrefund")
    public Receipt payment(@RequestParam String name,@RequestParam int id){
        return Customercontroller.requestRefund(name,id);

    }
    @GetMapping("/Myreceipt")
    public Receipt[] payment(@RequestParam String name) {
        return Customercontroller.printrec(name);
    }
    @PostMapping("/Addwallet")
    public addmoney add(@RequestParam String name,@RequestParam double amount){
      return Customercontroller.addwallet(name, amount);
    }

}