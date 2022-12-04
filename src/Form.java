public class Form {
    private Service service;
    Form(Service s){
        this.service=s;
    }
    Form(){
        
    }
    void createService(int option){
		if(option == 1){
			service = new Mobile();
		}
        else if(option == 2){
            service = new Internet();
        }
        else if(option == 3){
            service = new Landline();
        }
        else if(option == 4){
            service = new Donation();
        }
	}
}

