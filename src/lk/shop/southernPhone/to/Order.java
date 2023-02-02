package lk.shop.southernPhone.to;

import java.time.LocalDate;

public class Order {
    private String o_id;
    private LocalDate date;
    private String c_id;

    public Order(){}

    public Order(String o_id,LocalDate date,String c_id){
        this.setO_id(o_id);
        this.setDate(date);
        this.setC_id(c_id);

    }


    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "o_id='" + o_id + '\'' +
                ", date=" + date +
                ", c_id='" + c_id + '\'' +
                '}';
    }
}
