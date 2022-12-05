public class Receipt {
    int customerId = 0;
    Payment p;
    private String serivcename;
    private int ReceiptId = 0;
    private String Statue;
    private int amount;

    Receipt(int customerId, int ReceiptId, String serivcename, int amount) {
        this.customerId = customerId;
        this.ReceiptId = ReceiptId;
        this.serivcename = serivcename;
        this.amount = amount;
    }

    public int getCutomer() {
        return customerId;
    }

    public int getReceiptId() {
        return ReceiptId;
    }

    public int getamount() {
        return amount;
    }

    public String getStatue() {
        return Statue;
    }

    public String getserivcename() {
        return serivcename;
    }

    public void printReceipt(int customerId, int ReceiptId, String Statue, int amount) {
        System.out.println(customerId);
        System.out.println(ReceiptId);
        System.out.println(Statue);
        System.out.println(amount);
        System.out.println("========================================");
    }

}
