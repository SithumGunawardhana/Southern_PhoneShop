package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.model.SupplierModel;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Supplier;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public JFXTextField jfxbtxtSearch;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtAddress;
    public TextField txtNumber;
    public TextField txtNIC;
    public JFXButton jfxbtnHome;

    public Button btnClear;
    public TableView<Supplier> tblSupplier;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colAddress;
    public TableColumn colNumber;
    public TableColumn colNic;


    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAge.setCellValueFactory(new PropertyValueFactory("age"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory("number"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));


        try {
            loadAllCustomers();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }


    }
    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result1= CrudUtil.execute("SELECT * FROM Supplier");
        ObservableList<Supplier> obList = FXCollections.observableArrayList();

        while(result1.next()) {
            obList.add(new Supplier(
                    result1.getString("su_id"),
                    result1.getString("su_name"),
                    result1.getInt("su_age"),
                    result1.getString("su_address"),
                    result1.getString("su_number"),
                    result1.getString("su_NIC")));
        }

        this.tblSupplier.setItems(obList);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();
        String number = txtNumber.getText();
        String nic = txtNIC.getText();

        Supplier supplier = new Supplier(id, name, age, address, number, nic);

        try {
            boolean isAdded = SupplierModel.save(supplier);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.WELCOME,pane2);
    }

    public void UpdateOnAction(ActionEvent actionEvent) {

        String id=txtId.getText();
        String address=txtAddress.getText();
        String number=txtNumber.getText();

        Supplier supplier=new Supplier(id,address,number);

        try {
            boolean isUpdate=SupplierModel.update(supplier);
            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"supplier Upadate!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING,"Not update!");

        }

    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtName.clear();
        txtAge.clear();
        txtAddress.clear();
        txtNumber.clear();
        txtNIC.clear();
    }
}
