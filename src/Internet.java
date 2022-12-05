public class Internet implements Service
{
    ServiceProvider prov;
    Internet(){

    }
    public void createProvider(int option){
        if(option == 1){
            prov = new WEInternet();
        }
        else if(option == 2){
            prov = new VodafoneInternet();
        }
        else if(option == 3){
            prov = new EtisalatInternet();
        }
        else if(option == 4){
            prov = new OrangeInternet();
        }
    }
}

