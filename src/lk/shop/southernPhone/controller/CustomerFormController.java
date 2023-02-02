package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import lk.shop.southernPhone.model.CustomerModel;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.util.CrudUtil;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerFormController {
    public AnchorPane pane2;
    public TextField txtId;
    public Button btnSave;
    public JFXTextField jfxbtxtSearch;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtAddress;
    public TextField txtNumber;
    public TextField txtDOB;
    public JFXButton jfxbtnHome;
    public Button btnSearch;
    public TableView<Customer> tblCustomer;
    public TableColumn colCustomerId;
    public TableColumn colCustomerName;
    public TableColumn colCustomerAge;
    public TableColumn colCustomerAddress;
    public TableColumn colCustomerNumber;
    public TableColumn colCustomerDOB;
    public Button btnClear;


    public void initialize(){
        colCustomerId.setCellValueFactory(new PropertyValueFactory("Id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory("Name"));
        colCustomerAge.setCellValueFactory(new PropertyValueFactory("Age"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colCustomerNumber.setCellValueFactory(new PropertyValueFactory("Number"));
        colCustomerDOB.setCellValueFactory(new PropertyValueFactory("Dob"));


        try {
            loadAllCustomers();
        } catch (SQLException | ClassNotFoundException var2) {
            var2.printStackTrace();
            new Alert(Alert.AlertType.ERROR,var2.getMessage()).show();
        }


    }
    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result1= CrudUtil.execute("SELECT * FROM Customer");
        ObservableList<Customer> obList = FXCollections.observableArrayList();

        while(result1.next()) {
            obList.add(new Customer(
                    result1.getString("c_id"),
                    result1.getString("c_address"),
                    result1.getInt("c_age"),
                    result1.getString("c_dob"),
                    result1.getString("c_name"),
                    result1.getString("c_number")));
        }

        this.tblCustomer.setItems(obList);
    }



    public void SaveOnAction(ActionEvent actionEvent) throws IOException {
    String id=txtId.getText();
    String address=txtAddress.getText();
    int age= Integer.parseInt(txtAge.getText());
    String dob=txtDOB.getText();
    String name=txtName.getText();
    String number=txtNumber.getText();

        Customer customer=new Customer(id,address,age,dob,name,number);

        try {
            boolean isAdded= CustomerModel.save(customer);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Added!").show();
                clears();

            }

        }catch (SQLException|ClassNotFoundException e){
           e.printStackTrace();
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
           clears();
        }



    }





    public void SearchOnAction(ActionEvent actionEvent) {


    }

    public void HomeOnAction(ActionEvent actionEvent) throws Exception {
        Navigation.navigate2(Routes2.WELCOME,pane2);


    }


    public void CustomerIdOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();


        try {
            Customer customer=CustomerModel.search(id);
            if (customer !=null) {
                fillData(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void fillData(Customer customer){
        txtId.setText(customer.getId());
        txtAddress.setText(customer.getAddress());
        txtAge.setText(String.valueOf(customer.getAge()));
        txtDOB.setText(customer.getDob());
        txtName.setText(customer.getName());
        txtNumber.setText(customer.getNumber());


    }


    public void ClearOnAction(ActionEvent actionEvent) {
           clears();

    }

    public void clears(){
        txtId.clear();;
        txtAddress.clear();
        txtAge.clear();
        txtDOB.clear();
        txtName.clear();
        txtNumber.clear();


    }



}

