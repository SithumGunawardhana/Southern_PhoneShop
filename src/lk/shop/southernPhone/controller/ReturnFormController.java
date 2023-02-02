package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.model.Return1Model;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Return1;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public JFXTextField jfxbtxtSearch;
    public TextField txtDescription;
    public JFXButton jfxbtnHome;
    public Button btnClear;
    public TextField txtSuId;
    public TextField txtCusId;
    public TableView<Return1> tblReturn;
    public TableColumn colReturnId;
    public TableColumn colDescription;
    public TableColumn colCustomerId;
    public TableColumn colSupplierId;

    public void initialize(){
        colReturnId.setCellValueFactory(new PropertyValueFactory("id"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory("Customer"));
        colSupplierId.setCellValueFactory(new PropertyValueFactory("Supplier"));


        try {
            loadAllReturn();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }


    }
    private void loadAllReturn() throws ClassNotFoundException, SQLException {
        ResultSet result= CrudUtil.execute("SELECT * FROM Returns");
        ObservableList<Return1> obList = FXCollections.observableArrayList();

        while(result.next()) {
            obList.add(new Return1(
                    result.getString("re_id"),
                    result.getString("re_description"),
                    result.getString("c_id"),
                    result.getString("su_id")));
        }

        this.tblReturn.setItems(obList);
    }

    public void SaveOnAction(ActionEvent actionEvent)  {
        String id=txtId.getText();
        String description=txtDescription.getText();
        String c_id=txtCusId.getText();
        String su_id=txtSuId.getText();

        Return1 return1=new Return1(id,description,c_id,su_id);


        try {
            boolean isAdded = Return1Model.save(return1);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Not Added!").show();
            }
        } catch (Exception e) {
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
        txtDescription.clear();
        txtSuId.clear();
        txtCusId.clear();

    }
}
