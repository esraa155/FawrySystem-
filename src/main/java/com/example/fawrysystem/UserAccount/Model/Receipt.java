package com.example.fawrysystem.UserAccount.Model;
import com.example.fawrysystem.Database.*;

public class Receipt {

    private String username;
    private int id=0;
    private String serviceName;
    private String provName;
    private String Discount;
    protected double servicePrice=0;
    private double userAmount;
    private String paymentway;
    private String Status;

    public double getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(double userAmount) {
        this.userAmount = userAmount;
    }


    public String getProvName() {
        return provName;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public Receipt(double servicePrice,double userAmount,String discount,String username,int customerReceiptId,String serviceName,String provName,String Status,String paymentway) {
        this.Discount=discount;
        this.username=username;
        this.userAmount=userAmount;
        this.id=customerReceiptId;
        this.serviceName=serviceName;
        this.provName=provName;
        this.paymentway=paymentway;
        this.servicePrice=servicePrice;
        this.Status=Status;
    }
    public Receipt(double d,String username,int customerReceiptId) {

        this.servicePrice=d;
        this.username=username;
        this.id=customerReceiptId;

    }
    public Receipt() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public double getServicePrice() {
        return servicePrice;
    }
    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    Admin admin=new Admin();


    public Receipt[] printrec(String name) {
        boolean f = false;
        for (Customer customer : CustomerDB.customers) {
            if (customer.getUsername().equals(name)) {
                int i = CustomerDB.customers.indexOf(customer);
                if (CustomerDB.customers.get(i).isLoggedIn()) {
                    f = true;
                }
            }
        }
        if (f) {
            int n = 0;
            for (int j = 0; j < ReceiptDB.tr.size(); j++) {
                if (name.equals(ReceiptDB.tr.get(j).getUsername()))
                    n += 1;
            }
            Receipt[] rec = new Receipt[n];
            for (int j = 0; j < ReceiptDB.tr.size(); j++) {
                if (name.equals(ReceiptDB.tr.get(j).getUsername()))
                    rec[j] = ReceiptDB.tr.get(j);
            }
            return rec;

        } else {
            Receipt receipt = new Receipt(0, 0, 0 + "", "Error Customer", 0, " ", " ", "", "");
            return new Receipt[] { receipt };
        }
    }
}