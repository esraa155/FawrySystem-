public class Etisalat implements ServiceProvider{
    Etisalat(){
        
   }

   EtisalatMobile M;
   EtisalatInternet I;
   public void createProvider(int option){
       if(option == 1){
           M = new EtisalatMobile();
       }
       else if(option == 2){
           I = new EtisalatInternet();
       }
     
   }
}   
