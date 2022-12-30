package com.example.Fawrysystem.Service;

import com.example.Fawrysystem.Service.ServiceProvider.*;

public class Mobile implements Service{
    ServiceProvider prov;
    String name ;
    Mobile(){

    }
    public void createProvider(int option){
        if(option == 1){
            prov = new WEMobile();

        }
        else if(option == 2){
            prov = new VodafoneMobile();

        }
        else if(option == 3){
            prov = new EtisalatMobile();

        }

        else if(option == 4){
            prov = new OrangeMobile();
        }
        name = prov.getname();
    }
    public String getname() {
        return name;
    }
}
