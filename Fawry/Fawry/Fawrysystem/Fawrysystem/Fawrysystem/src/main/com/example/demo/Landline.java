public class Landline  implements Service {
	
	Plan p;
    String name;
    Landline(){
       
    }
    public void createProvider(int option){
        if(option == 1){
            p = new Quarter();
         
            
        }
        else if(option == 2){
            p = new Monthly();
        }
      name = p.getname();
    }
    @Override
    public String getname() {
       return name;
    }
}