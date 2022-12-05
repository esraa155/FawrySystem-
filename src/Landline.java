public class Landline  implements Service {
    Plan p;
    Landline(){
        
    }
    public void createProvider(int option){
        if(option == 1){
            p = new Quarter();
        }
        else if(option == 2){
            p = new Monthly();
        }
      
    }
    public boolean contains(String name_) {
        // TODO Auto-generated method stub
        return false;
    }
}