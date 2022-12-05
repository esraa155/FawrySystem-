public class Landline  implements Service {
    Plan p;
    Landline(){
        
    }
    public void createProvider(int option,Customer c){
        if(option == 1){
            p = new Quarter();
            p.getname();
            p.pay(c);
        }
        else if(option == 2){
            p = new Monthly();
            p.getname();
            p.pay(c);
        }
      
    }
}