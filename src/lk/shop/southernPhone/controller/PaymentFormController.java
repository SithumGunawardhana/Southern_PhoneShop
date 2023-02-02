package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.model.PaymentModel;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Payment;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PaymentFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public JFXTextField jfxbtxtSearch;

    public TextField txtBill;
    public JFXButton jfxbtnHome;
    public Button btnClear;
    public TextField txtDescription;
    public TextField txtCost;
    public TableView <Payment> tblPayment;
    public TableColumn colId;
    public TableColumn colDescription;
    public TableColumn colBillName;
    public TableColumn colCost;


    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        colBillName.setCellValueFactory(new PropertyValueFactory("BillName"));
        colCost.setCellValueFactory(new PropertyValueFactory("cost"));

        try {
            loadAllCustomers();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }


    }
    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result1= CrudUtil.execute("SELECT * FROM Payment");
        ObservableList<Payment> obList = FXCollections.observableArrayList();

        while(result1.next()) {
            obList.add(new Payment(
                    result1.getString("pa_id"),
                    result1.getString("pa_description"),
                    result1.getString("pa_BillName"),
                    result1.getDouble("Pa_cost")));

        }

        this.tblPayment.setItems(obList);
    }



    public void SaveOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();
        String description=txtDescription.getText();
        String bill=txtBill.getText();
        double cost= Double.parseDouble(txtCost.getText());

        Payment payment=new Payment(id,description,bill,cost);

        try {
            boolean isAdded=PaymentModel.save(payment);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Payment is Added!").show();

            }else {
                new Alert(Alert.AlertType.WARNING,"Payment is Not Added!").show();
            }
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        }{

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
        txtBill.clear();
        txtCost.clear();
    }
}
