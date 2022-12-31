package com.example.fawrysystem.UserAccount.Model;
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


    public String getPaymentway() {
        return paymentway;
    }

    public void setPaymentway(String paymentway) {
        this.paymentway = paymentway;
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
}