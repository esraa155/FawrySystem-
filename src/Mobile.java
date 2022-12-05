public class Mobile  implements Service{

    ServiceProvider prov;
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
    }
    public boolean contains(String name_) {
        // TODO Auto-generated method stub
        return false;
    }
}

