package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.shop.southernPhone.model.RepairModel;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Repair;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public JFXTextField jfxbtxtSearch;

    public JFXButton jfxbtnHome;
    public JFXButton jfxbtnCustomer;
    public TextField txtProfit;
    public TextField txtC_id;
    public Button btnClear;

    public TableColumn colPaimentId;
    public TableColumn colProfit;
    public TableColumn colCustomerId;
    public TableView<Repair> tblRepair;

    public void initialize(){
        colPaimentId.setCellValueFactory(new PropertyValueFactory("PaymentId"));
        colProfit.setCellValueFactory(new PropertyValueFactory("Profit"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory("CustomerId"));


        try {
            loadAllRepair();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }


    }
    private void loadAllRepair() throws ClassNotFoundException, SQLException {
        ResultSet result1= CrudUtil.execute("SELECT * FROM Repair");
        ObservableList<Repair> obList = FXCollections.observableArrayList();

        while(result1.next()) {
            obList.add(new Repair(
                    result1.getString("r_id"),
                    result1.getDouble("r_profit"),
                    result1.getString("c_id")));

        }

        this.tblRepair.setItems(obList);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();
        double profit= Double.parseDouble(txtProfit.getText());
        String c_id=txtC_id.getText();

        Repair repair=new Repair(id,profit,c_id);

        try {
            boolean isAdded= RepairModel.save(repair);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Repair Added!").show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Repair is not Added!").show();
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

    public void CustomerAddOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/shop/southernPhone/view/CustomerForm.fxml"));
        Stage stage=new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Customer Form");
        stage.centerOnScreen();
        stage.show();



    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtProfit.clear();
        txtC_id.clear();
    }
}
