public abstract class WE implements ServiceProvider {
    WE(){
        
    }
    WEMobile M;
    WEInternet I;
    public void createProvider(int option){
        if(option == 1){
            M = new WEMobile();
        }
        else if(option == 2){
            I = new WEInternet();
        }
      
    }
}
