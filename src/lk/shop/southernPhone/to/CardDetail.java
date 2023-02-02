package lk.shop.southernPhone.to;

public class CardDetail {
    private String o_id;
    private String i_id;
    private String i_model;
    private double i_unitPrice;
    private int oi_qty;

    private double getPrice;





    public CardDetail(String o_id, String i_id, String i_model, double i_unitPrice, int oi_qty,  double getPrice) {
        this.setO_id(o_id);
        this.setI_id(i_id);
        this.setI_model(i_model);
        this.setI_unitPrice(i_unitPrice);
        this.setOi_qty(oi_qty);

        this.setGetPrice(getPrice);
    }



//tm.getO_id(), tm.getI_id(), tm.getI_model(),tm.getI_unitPrice(),tm.getQty()

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
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

    public double getI_unitPrice() {
        return i_unitPrice;
    }

    public void setI_unitPrice(double i_unitPrice) {
        this.i_unitPrice = i_unitPrice;
    }

    public int getOi_qty() {
        return oi_qty;
    }

    public void setOi_qty(int oi_qty) {
        this.oi_qty = oi_qty;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    @Override
    public String toString() {
        return "CardDetail{" +
                "o_id='" + o_id + '\'' +
                ", i_id='" + i_id + '\'' +
                ", i_model='" + i_model + '\'' +
                ", i_unitPrice=" + i_unitPrice +
                ", oi_qty=" + oi_qty +
                ", getPrice=" + getPrice +
                '}';
    }
}
