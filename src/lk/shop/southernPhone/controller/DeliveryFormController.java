package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.model.DeliveryModel;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Delivery;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public JFXTextField jfxbtxtSearch;
    public TextField txtAddress;
    public TextField txtCusId;
    public TextField txtOId;
    public JFXButton jfxbtnHome;
    public Button btnClear;
    public TableView<Delivery> tblDelivery;
    public TableColumn colDeliveryId;
    public TableColumn colDeliveryAddress;
    public TableColumn colCustomerId;
    public TableColumn ColOrderId;

    public void initialize() {
        colDeliveryId.setCellValueFactory(new PropertyValueFactory("Address"));
        colDeliveryAddress.setCellValueFactory(new PropertyValueFactory("Id"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory("c_id"));
        ColOrderId.setCellValueFactory(new PropertyValueFactory("O_id"));


        try {
            this.loadAllDelivery();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }
    }
    private void loadAllDelivery() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Delevery");
        ObservableList<Delivery> obList = FXCollections.observableArrayList();

        while(result.next()) {
            obList.add(new Delivery(

                    result.getString("de_address"),
                    result.getString("de_id"),
                    result.getString("c_id"),
                    result.getString("O_id")));
        }

        this.tblDelivery.setItems(obList);
    }





    public void SaveOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();
        String address=txtAddress.getText();
        String c_id=txtCusId.getText();
        String o_id=txtOId.getText();

        Delivery delivery=new Delivery(id,address,c_id,o_id);

        try {
            boolean isAdded= DeliveryModel.save(delivery);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Delivery Added!").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Delivery is not Added!").show();
            }

        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

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
        txtAddress.clear();
        txtCusId.clear();
        txtOId.clear();
    }
}
