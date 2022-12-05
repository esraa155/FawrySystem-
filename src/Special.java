public class Special extends Discount {
  private double perc;
  Payment pay;
  Customer c;
  private String companyname;

  public Special() {
  }
    public Special(String n, double perc2) {
    this.companyname=n;
    this.perc=perc2;
  }
  
    public Special add(String n,double perc){
    if(perc>1){
      perc/=100;
    }
    Special s =new Special(n,perc);
    Database.discount.add(s);
    return s;
    }

  
  @Override
  public double pdisco_calcuay(double amount, double prec) {
    amount = amount-(amount*perc);
    return amount;
  }
  public double getPerc() {
    return perc;
  }
  public void setPerc(double perc) {
    this.perc = perc;
  }
  public Payment getPay() {
    return pay;
  }
  public void setPay(Payment pay) {
    this.pay = pay;
  }
  public Customer getC() {
    return c;
  }
  public void setC(Customer c) {
    this.c = c;
  }
  public String getCompanyname() {
    return companyname;
  }
  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

}
