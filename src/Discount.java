public abstract class  Discount {
    protected Payment p;
    int amount;
    Customer c;

    public Discount(Payment p)
    {

        this.p = p;
    }
 
    public void pay()
    { 

        p.pay(c.getAmount(),amount);
     }
}

