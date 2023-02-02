package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Order;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {

    public static boolean save(Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Orders VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, order.getO_id(), order.getDate(), order.getC_id());
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT o_id FROM orders ORDER BY o_id DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);
        if (result.next()) {
            return generateNextOrderId(result.getString(1));

        }
        return generateNextOrderId(result.getString(null));
    }

    private static String generateNextOrderId(String currentOrderId) {

        if (currentOrderId != null) {
            String[] split = currentOrderId.split("D0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "D0" + id;
        }
        return "O001";



    }

}
