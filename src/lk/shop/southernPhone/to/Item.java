package lk.shop.southernPhone.to;

public class Item {
    private String i_id;
    private String i_model;
    private String i_brand;
    private double i_getPrice;
    private int i_QOH;
    private double i_unitPrice;

    public Item(){}

    public Item(String i_id, String i_model, String i_brand, double i_getPrice, int i_QOH, double i_unitPrice){
        this.setI_id(i_id);
        this.setI_model(i_model);
        this.setI_brand(i_brand);
        this.setI_getPrice(i_getPrice);
        this.setI_QOH(i_QOH);
        this.setI_unitPrice(i_unitPrice);
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getI_model() {
        return i_model;
    }

    public void setI_model(String i_model) {
        this.i_model = i_model;
    }

    public String getI_brand() {
        return i_brand;
    }

    public void setI_brand(String i_brand) {
        this.i_brand = i_brand;
    }

    public double getI_getPrice() {
        return i_getPrice;
    }

    public void setI_getPrice(double i_getPrice) {
        this.i_getPrice = i_getPrice;
    }

    public int getI_QOH() {
        return i_QOH;
    }

    public void setI_QOH(int i_QOH) {
        this.i_QOH = i_QOH;
    }

    public double getI_unitPrice() {
        return i_unitPrice;
    }

    public void setI_unitPrice(double i_unitPrice) {
        this.i_unitPrice = i_unitPrice;
    }

    @Override
    public String toString() {
        return "item{" +
                "i_id='" + i_id + '\'' +
                ", i_model='" + i_model + '\'' +
                ", i_brand='" + i_brand + '\'' +
                ", i_getPrice=" + i_getPrice +
                ", i_QOH=" + i_QOH +
                ", i_unitPrice=" + i_unitPrice +
                '}';
    }
}
