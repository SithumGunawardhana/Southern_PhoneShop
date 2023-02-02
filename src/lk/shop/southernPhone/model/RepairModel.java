package lk.shop.southernPhone.model;

import javafx.scene.Parent;
import lk.shop.southernPhone.to.Repair;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;

public class RepairModel {

    public static boolean save(Repair repair) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Repair VALUES(?,?,?)";
        return CrudUtil.execute(sql,repair.getId(),repair.getProfit(),repair.getC_id());
    }
}
