package lk.shop.southernPhone.to;

public class Payment {
    private String id;
    private String description;
    private String bill;
    private double cost;

    public Payment() {
    }

    public Payment(String id, String description, String bill, double cost) {
        this.setId(id);
        this.setDescription(description);
        this.setBill(bill);
        this.setCost(cost);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", bill='" + bill + '\'' +
                ", cost=" + cost +
                '}';
    }
}
