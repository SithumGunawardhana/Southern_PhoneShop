package lk.shop.southernPhone.to;

public class Delivery {
    private String id;
    private String address;
    private String c_id;
    private String o_id;

    public Delivery(){}

    public Delivery(String id,String address,String c_id,String o_id){
        this.setId(id);
        this.setAddress(address);
        this.setC_id(c_id);
        this.setO_id(o_id);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Delivery{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", c_id='" + c_id + '\'' +
                ", o_id='" + o_id + '\'' +
                '}';
    }
}
