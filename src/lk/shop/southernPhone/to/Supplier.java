package lk.shop.southernPhone.to;

public class Supplier {
    private String id;
    private String name;
    private int age;
    private String address;
    private String number;
    private String nic;

    public Supplier(String id, String address, String number){
        this.id=id;
        this.address=address;
        this.number=number;

    }

    public Supplier(String id,String name,int age,String address,String number,String nic){
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
        this.setNumber(number);
        this.setNic(nic);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
