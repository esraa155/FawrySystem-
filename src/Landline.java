public class Landline  implements Service {
    Plan p;
    Landline(){
        
    }
    public void createProvider(int option){
        if(option == 1){
            p = new Quarter();
            p.getname();
            p.pay();
        }
        else if(option == 2){
            p = new Monthly();
            p.getname();
            p.pay();
        }
      
    }
}