package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.model.ItemModel;
import lk.shop.southernPhone.to.Delivery;
import lk.shop.southernPhone.to.Item;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public JFXTextField jfxbtxtSearch;
    public TextField txtModel;
    public TextField txtBrand;
    public TextField txtGetPrice;
    public TextField txtSellPrice;
    public JFXButton jfxbtnHome;
    public Button btnClear;
    public TextField txtQOH;
    public TextField txtUnitPrice;
    public TableView<Item> tblItem;
    public TableColumn colId;
    public TableColumn colModel;
    public TableColumn colBrand;
    public TableColumn colGetPrice;
    public TableColumn colUnitPrice;
    public TableColumn colQOH;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colModel.setCellValueFactory(new PropertyValueFactory("model"));
        colBrand.setCellValueFactory(new PropertyValueFactory("brand"));
        colGetPrice.setCellValueFactory(new PropertyValueFactory("getPrice"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("UnitPrice"));
        colQOH.setCellValueFactory(new PropertyValueFactory("QutyOnHand"));


        try {
            this.loadAllDelivery();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }
    }
    private void loadAllDelivery() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM item");
        ObservableList<Item> obList = FXCollections.observableArrayList();

        while(result.next()) {
            obList.add(new Item(

                    result.getString("I_id"),
                    result.getString("I_model"),
                    result.getString("I_Brand"),
                    result.getDouble("I_GetPrice"),
                    result.getInt("QOHand"),
                    result.getDouble("I_UnitPrice")));

        }

        this.tblItem.setItems(obList);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String i_id=txtId.getText();
        String i_model=txtModel.getText();
        String i_brand=txtBrand.getText();
        double i_getPrice= Double.parseDouble(txtGetPrice.getText());
        int i_QOH= Integer.parseInt(txtQOH.getText());
        double i_unitPrice= Double.parseDouble(txtUnitPrice.getText());


        Item item=new Item(i_id,i_model,i_brand,i_getPrice,i_QOH,i_unitPrice);

        try {
            boolean isAdded = ItemModel.save(item);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item is Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Item Is not Added!").show();
            }
        }catch (Exception e){
            throw  new RuntimeException(e);
        }


    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.WELCOME,pane2);
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtBrand.clear();
        txtModel.clear();
        txtQOH.clear();
        txtGetPrice.clear();
        txtUnitPrice.clear();
    }
}
