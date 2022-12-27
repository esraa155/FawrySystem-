public class Receipt {

    Customer c=new Customer();
    private String serviceName;
    private int customerReceiptId;
    protected double servicePrice;
    private String serviceStatus;
    private String serviceCode;
    int username;
    public int userNumId;
    public Receipt(double servicePrice,int username,int customerReceiptId,String serviceName,String serviceCode) {

        this.servicePrice=servicePrice;
        this.username=username;
        this.customerReceiptId=customerReceiptId;
        this.serviceName=serviceName;
        this.serviceCode=serviceCode;

    }
    public Receipt(double d,int username,int customerReceiptId) {

        this.servicePrice=d;
        this.username=username;
        this.customerReceiptId=customerReceiptId;
        
      }

        public String getServiceName() {
            return serviceName;
        }

        public String getServiceStatus() {
            return serviceStatus;
        }
        public String getServiceCode() {
            return serviceCode;
        }
        public void setServiceStatus(String serviceStatus) {
            this.serviceStatus = serviceStatus;
        }

}
