package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer VALUES(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,customer.getId(),customer.getAddress(),customer.getAge(),customer.getDob(),customer.getName(),customer.getNumber());
    }


/*
public static boolean loadAll(Customer customer) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM Customer";
        return CrudUtil.execute(sql,customer.getId(),customer.getName(),customer.getAge(),customer.getAddress(),customer.getNumber(),customer.getDob());
}

*/
public static Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT  * FROM Customer WHERE c_id = ?";
    ResultSet result=CrudUtil.execute(sql,id);

    if(result.next()){
        return new Customer(
                result.getString(1),
                result.getString(2),
                result.getInt(3),
                result.getString(4),
                result.getString(5),
                result.getString(6)

        );
    }

    return null;
}



    public static ArrayList<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT c_id FROM Customer");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static Customer getCustomer(String c_id) throws SQLException, ClassNotFoundException {

        ResultSet result= CrudUtil.execute("SELECT * FROM Customer WHERE c_id=?",c_id);
        if (result.next()){
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }

}
