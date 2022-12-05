public class Vodafone implements ServiceProvider {
 Vodafone(){
        
    }


    VodafoneMobile M;
    VodafoneInternet I;
   public void createProvider(int option){
       if(option == 1){
           M = new VodafoneMobile();
       }
       else if(option == 2){
           I = new VodafoneInternet();
       }
     
   }
}
