public class Internet implements Service
{
    ServiceProvider prov;
    Internet(){
    }
    public void createProvider(int option){
        if(option == 1){
            prov = new WEInternet();
            prov.getname();
            prov.pay();
        }
        else if(option == 2){
            prov = new VodafoneInternet();
            prov.getname();
            prov.pay();
        }
        else if(option == 3){
            prov = new EtisalatInternet();
            prov.getname();
            prov.pay();
        }
        else if(option == 4){
            prov = new OrangeInternet();
            prov.getname();
            prov.pay();
        }
    }
}

