package lk.shop.southernPhone.to;

import java.util.ArrayList;

public class PlaceOrder {
    private String c_id;
    private String o_id;
    private ArrayList<CardDetail> orderDetail=new ArrayList<>();

    public PlaceOrder(){}

    public PlaceOrder(String c_id,String o_id,ArrayList<CardDetail> orderDetail){
        this.setC_id(c_id);
        this.setO_id(o_id);
        this.setOrderDetail(orderDetail);
    }


    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public ArrayList<CardDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<CardDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "c_id='" + c_id + '\'' +
                ", o_id='" + o_id + '\'' +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
