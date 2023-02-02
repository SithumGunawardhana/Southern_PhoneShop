package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Payment;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;

public class PaymentModel {
    public static boolean save(Payment payment) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO payment VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,payment.getId(),payment.getDescription(),payment.getBill(),payment.getCost());
    }


}
