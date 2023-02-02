package lk.shop.southernPhone.model;

import lk.shop.southernPhone.to.Return1;
import lk.shop.southernPhone.util.CrudUtil;

import java.sql.SQLException;

public class Return1Model {
    public  static boolean save(Return1 return1) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO Returns VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,return1.getId(),return1.getDescription(),return1.getC_id(),return1.getSu_id());


    }
}
