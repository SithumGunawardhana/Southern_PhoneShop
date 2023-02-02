package lk.shop.southernPhone.to;

public class Repair {

    private String id;
    private double profit;
    private String c_id;

    public Repair(){}

    public Repair(String id,double profit,String c_id){
        this.setId(id);
        this.setProfit(profit);
        this.setC_id(c_id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id='" + id + '\'' +
                ", profit=" + profit +
                ", c_id='" + c_id + '\'' +
                '}';
    }
}
