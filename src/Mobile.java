public class Mobile  implements Service{

    ServiceProvider prov;
    Mobile(){

    }
    public void createProvider(int option){
        if(option == 1){
            prov = new WEMobile();	
            prov.getname();
            prov.pay();				
        }
        else if(option == 2){
            prov = new VodafoneMobile();
            prov.getname();
            prov.pay();	
        }
        else if(option == 3){
            prov = new EtisalatMobile();
            prov.getname();
            prov.pay();	
        }
        else if(option == 4){
            prov = new OrangeMobile();
            prov.getname();
            prov.pay();	
        }
    }
}

