public class Receipt {

    Customer c=new Customer();
    public Receipt(double d,int username,int customerReceiptId,String serviceName,String serviceCode) {

        this.servicePrice=d;
        this.userNum=username;
        this.customerReceiptId=customerReceiptId;
        this.serviceName=serviceName;
        this.serviceCode=serviceCode;

    }
    public Receipt(double d,int username,int customerReceiptId) {

        this.servicePrice=d;
        this.userNum=username;
        this.customerReceiptId=customerReceiptId;
        
    }
        private String serviceName;
        private int customerReceiptId;
        private double servicePrice;
        private String serviceStatus;
        private String serviceCode;

        int userNum;

        public Integer userNumId;
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
