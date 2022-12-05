public class Orange implements ServiceProvider {
   Orange(){
   }

   OrangeMobile M;
   OrangeInternet I;
   public void createProvider(int option){
       if(option == 1){
           M = new OrangeMobile();
       }
       else if(option == 2){
           I = new OrangeInternet();
       }
     
   }
}