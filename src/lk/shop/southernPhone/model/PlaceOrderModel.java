package lk.shop.southernPhone.model;

import db.DBConnection;
import lk.shop.southernPhone.to.Order;
import lk.shop.southernPhone.to.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {

    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
     try {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        boolean isOrderAdded = OrderModel.save(new Order(placeOrder.getO_id(), LocalDate.now(), placeOrder.getC_id()));
        if (isOrderAdded) {
            boolean isUpdated = ItemModel.updateQty(placeOrder.getOrderDetail());
            if (isUpdated) {
                boolean isOrderDetailAdded = Order_itemModel.saveOrderDetails(placeOrder.getOrderDetail());
                if (isOrderDetailAdded) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
        }
        DBConnection.getInstance().getConnection().rollback();
        return false;
    } finally {
        DBConnection.getInstance().getConnection().setAutoCommit(true);
    }
    }

}
