package com.example.fawrysystem.Service;

import com.example.fawrysystem.Service.Plan.Monthly;
import com.example.fawrysystem.Service.Plan.Plan;
import com.example.fawrysystem.Service.Plan.Quarter;

public class Landline implements Service{
    Plan p;
    String name;
    Landline(){

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
