package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Delivery;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;

public class DeliveryModel {
    public static boolean save(Delivery delivery) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Delevery VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,delivery.getId(),delivery.getAddress(),delivery.getC_id(),delivery.getO_id());
    }

}
