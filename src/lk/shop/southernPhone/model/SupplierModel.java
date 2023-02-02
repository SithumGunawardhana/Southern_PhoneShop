package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Supplier;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;

public class SupplierModel {

    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Supplier VALUES(?,?,?,?,?,?)";
        return CrudUtil.execute(sql, supplier.getId(), supplier.getName(), supplier.getAge(), supplier.getAddress(), supplier.getNumber(), supplier.getNic());
    }

    public static boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql="UPDATE supplier SET address=?,number=? WHERE id=?";
        return CrudUtil.execute(sql,supplier.getAddress(),supplier.getNumber(),supplier.getId());
    }



}
