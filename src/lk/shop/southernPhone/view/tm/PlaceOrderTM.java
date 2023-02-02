package lk.shop.southernPhone.view.tm;

import javafx.scene.control.Button;

public class PlaceOrderTM {

    private String o_id;
    private String i_id;
    private String i_model;
    private double i_unitPrice;
    private int oi_qty;
    private double total;
    private Button btnDelete;




    public PlaceOrderTM(){
    }
    public PlaceOrderTM(String o_id, String i_id, String i_model, double i_unitPrice, int oi_qty, double total, Button btnDelete){
        this.setO_id(o_id);
        this.setI_id(i_id);
        this.setI_model(i_model);
        this.setI_unitPrice(i_unitPrice);
        this.setOi_qty(oi_qty);
        this.setTotal(total);
        this.setBtnDelete(btnDelete);

    }


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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }


    @Override
    public String toString() {
        return "PlaceOrderTM{" +
                "o_id='" + o_id + '\'' +
                ", i_id='" + i_id + '\'' +
                ", i_model='" + i_model + '\'' +
                ", i_unitPrice=" + i_unitPrice +
                ", oi_qty=" + oi_qty +
                ", total=" + total +
                ", btnDelete=" + btnDelete +
                '}';
    }
}

