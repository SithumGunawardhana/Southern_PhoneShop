package lk.shop.southernPhone.to;

public class Return1 {
    private String id;
    private String description;
    private String c_id;
    private String su_id;

    public Return1(){
    }

    public Return1(String id, String description, String c_id, String su_id){
        this.setId(id);
        this.setDescription(description);
        this.setC_id(c_id);
        this.setSu_id(su_id);
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

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getSu_id() {
        return su_id;
    }

    public void setSu_id(String su_id) {
        this.su_id = su_id;
    }

    @Override
    public String toString() {
        return "Return{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", c_id='" + c_id + '\'' +
                ", su_id='" + su_id + '\'' +
                '}';
    }
}
