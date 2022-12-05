import java.util.Scanner;

public abstract class Orange implements ServiceProvider {
   String name ="service for Orange ";

   public abstract void getname();{
       System.out.println(name);
   }
   public abstract void pay() ;{
     }
}