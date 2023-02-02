package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.CardDetail;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class Order_itemModel {

    public static boolean saveOrderDetails(ArrayList<CardDetail> cardDetails) throws SQLException, ClassNotFoundException {
        for (CardDetail cardDetail : cardDetails) {
            if (!save(cardDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(CardDetail cardDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Order_item VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cardDetail.getI_id(), cardDetail.getO_id(), cardDetail.getOi_qty(), cardDetail.getI_unitPrice());
    }

}
