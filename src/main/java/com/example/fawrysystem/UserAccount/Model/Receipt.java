package com.example.fawrysystem.UserAccount.Model;


public class Receipt {

    private int id=0;
    private String serviceName;
    protected double servicePrice=0;
    private String Status;
    private String username;

    public Receipt(double servicePrice,String username,int customerReceiptId,String serviceName,String Status) {

        this.servicePrice=servicePrice;
        this.username=username;
        this.id=customerReceiptId;
        this.serviceName=serviceName;
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



}