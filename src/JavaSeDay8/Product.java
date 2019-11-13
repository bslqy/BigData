package JavaSeDay8;

public class Product {
    private String pID;
    private String pName;
    private float price;
    private int stockNum;

    public Product(String pID, String pName, float price, int stockNum) {
        this.pID = pID;
        this.pName = pName;
        this.price = price;
        this.stockNum = stockNum;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pID='" + pID + '\'' +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", stockNum=" + stockNum +
                '}';
    }
}
