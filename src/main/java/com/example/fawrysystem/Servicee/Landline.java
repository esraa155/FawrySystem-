package com.example.fawrysystem.Servicee;
import com.example.fawrysystem.Service.Plan.*;

public class Landline implements Servicee {
    Plan p;
    String name;
    public Landline(){

    }
    public void createProvider(int option){
        if(option == 1){
            p = new Quarter();


        }
        else if(option == 2){
            p = new Monthly();
        }
        name = p.getname();
    }
    @Override
    public String getname() {
        return name;
    }
}

