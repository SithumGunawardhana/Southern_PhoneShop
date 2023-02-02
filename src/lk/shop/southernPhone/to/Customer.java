package lk.shop.southernPhone.to;

public class Customer {

    private String id;
    private String address;
    private int age;
    private String dob;
    private String name;
    private String number;



    public Customer(String id, String address,int age,String dob,String name,String number){
        this.setId(id);
        this.setAddress(address);
        this.setAge(age);
        this.setDob(dob);
        this.setName(name);
        this.setNumber(number);

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", age=" + getAge() +
                ", dob='" + getDob() + '\'' +
                ", name='" + getName() + '\'' +
                ", number='" + getNumber() + '\'' +
                '}';
    }
}
