package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.CardDetail;
import lk.shop.southernPhone.to.Item;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static boolean save(Item item) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO item VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql,item.getI_id(),item.getI_model(),item.getI_brand(),item.getI_getPrice(),item.getI_QOH(),item.getI_unitPrice());
    }


    public static ArrayList<String> loadItemIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT i_id FROM Item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }


    public static Item search(String i_id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Item WHERE i_id = ?";
        ResultSet result = CrudUtil.execute(sql, i_id);

        if (result.next()) {
            return new Item(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getInt(5),
                    result.getDouble(6)
            );
        }
        return null;
    }

    public static boolean updateQty(ArrayList<CardDetail> cardDetails) throws SQLException, ClassNotFoundException {
        for (CardDetail cardDetail : cardDetails) {
            if (!updateQty(new Item(cardDetail.getO_id(),cardDetail.getI_id(), cardDetail.getI_model(),cardDetail.getGetPrice(),cardDetail.getOi_qty(),cardDetail.getI_unitPrice()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET QOHand = QOHand - ? WHERE I_id = ?";
        return CrudUtil.execute(sql, item.getI_QOH(), item.getI_id());
    }








}
