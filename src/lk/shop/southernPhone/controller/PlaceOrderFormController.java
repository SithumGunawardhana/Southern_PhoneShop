package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.shop.southernPhone.model.CustomerModel;
import lk.shop.southernPhone.model.ItemModel;
import lk.shop.southernPhone.model.OrderModel;
import lk.shop.southernPhone.model.PlaceOrderModel;
import lk.shop.southernPhone.to.CardDetail;
import lk.shop.southernPhone.to.Customer;
import lk.shop.southernPhone.to.Item;
import lk.shop.southernPhone.to.PlaceOrder;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes2;
import lk.shop.southernPhone.view.tm.PlaceOrderTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class PlaceOrderFormController {
    public AnchorPane pane2;
    public ComboBox<String> cmbCustomerId;
    public TextField txtId;
    public JFXButton jfxbtnAddCustomer;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtAddress;
    public TextField txtDOB;
    public TextField txtNumber;



    public TextField txtQty;

    public JFXTextField jfxtxtNetTotal;
    public Button btnAdd;
    public Button btnClear;
    public Button btnClose;
    public JFXComboBox jfxComboItemId;

    public Label lblTime;
    public Label lblDate;
    public Label lblId;
    public Label lblModel;
    public Label lblUnitPrice;
    public TableView <PlaceOrderTM>tblCart;
    public TableColumn colO_id;
    public TableColumn colI_id;
    public TableColumn colModel;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colDelete;

    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();



    public void initialize(){
        loadItemids();
        setCellValueFactory();
        setCustomerIds();
        loadNextOrderId();


        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    hour = cal.get(Calendar.HOUR);
                    //System.out.println(hour + ":" + (minute) + ":" + second);

                        lblTime.setText((hour) + ":" + (minute) + ":" + second);
                    try {

                        sleep(1000);
                    } catch (InterruptedException ex ) {
                        throw new RuntimeException(ex);

                    }
                }
            }
        };
        clock.start();
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void AddCustomer(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/shop/southernPhone/view/CustomerForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Customer Form");
        stage.centerOnScreen();
        stage.show();
    }

    public void orderNowOnAction(ActionEvent actionEvent) {
        String orderId = lblId.getText();
        String customerId = String.valueOf(cmbCustomerId.getValue());

        ArrayList<CardDetail> cardDetails = new ArrayList<>();

        PlaceOrder placeOrder = new PlaceOrder(customerId, orderId, cardDetails);
        try {
            boolean isPlaced = PlaceOrderModel.placeOrder(placeOrder);
            if (isPlaced) {
                obList.clear();
                loadNextOrderId();
                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            obList.clear();
            loadNextOrderId();
            new Alert(Alert.AlertType.ERROR,"Error");
        }


    }

    public void AddOnAction(ActionEvent actionEvent) {
        String o_id=lblId.getText();
        String i_id= String.valueOf(jfxComboItemId.getValue());
        String i_model=lblModel.getText();
        double i_uniPrice= Double.parseDouble(lblUnitPrice.getText());
        int oi_qty= Integer.parseInt(txtQty.getText());
        double total=i_uniPrice * oi_qty;
        Button btnDelete=new Button("Delete");


        txtQty.setText("");


        if (!obList.isEmpty()) {
            L1:

            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblCart.getItems().size(); i++) {
                if (colI_id.getCellData(i).equals(i_id)) {
                    oi_qty += (int) colQty.getCellData(i);
                    total = i_uniPrice * oi_qty;


                    obList.get(i).setOi_qty(oi_qty);
                    obList.get(i).setTotal(total);
                    tblCart.refresh();
                    return;
                }
            }

        }




        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                PlaceOrderTM tm = tblCart.getSelectionModel().getSelectedItem();


                tblCart.getItems().removeAll(tblCart.getSelectionModel().getSelectedItem());
            }
        });
        obList.add(new PlaceOrderTM(o_id,i_id,i_model , i_uniPrice, oi_qty, total, btnDelete));
        tblCart.setItems(obList);
    }








    public void RefreshOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.PLACE_ORDER,pane2);


    }




    private void setCustomerIds() {
        try {

            ObservableList<String> cIdObList = FXCollections.observableArrayList();
            ArrayList<String> idList=CustomerModel.getCustomerIds();

            for (String id: idList){
                cIdObList.add(id);
            }

            cmbCustomerId.setItems(cIdObList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void CloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void TimeOnAction(ActionEvent actionEvent) {

    }

    private void loadNextOrderId(){

        try {
            String o_id= OrderModel.generateNextOrderId();
            lblId.setText(o_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private int minute;
    private int hour;
    private int second;

    public void Time(MouseEvent mouseEvent) {

    }


    private void loadItemids() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = ItemModel.loadItemIds();

            for (String code : itemList) {
                observableList.add(code);
            }
            jfxComboItemId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void cmbCustomerIdOnAction(ActionEvent actionEvent) {
        String c_id=cmbCustomerId.getValue();
        try{
            Customer customer=CustomerModel.search(c_id);
            fillItemFields2(customer);

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private void fillItemFields2(Customer customer){
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAge.setText(String.valueOf(customer.getAge()));
        txtAddress.setText(customer.getAddress());
        txtDOB.setText(customer.getDob());
        txtNumber.setText(customer.getNumber());
    }

    public void cmbItemOnAction(ActionEvent actionEvent) {
        String i_id = (String) jfxComboItemId.getValue();
        try {
            Item item = ItemModel.search(i_id);
            fillItemFields(item);
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillItemFields(Item item){
        lblModel.setText(item.getI_model());
        lblUnitPrice.setText(String.valueOf(item.getI_unitPrice()));
    }

    public void setCellValueFactory(){
        colI_id.setCellValueFactory(new PropertyValueFactory("i_id"));
        colO_id.setCellValueFactory(new PropertyValueFactory("o_id"));
        colModel.setCellValueFactory(new PropertyValueFactory("i_model"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("i_unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory("oi_qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colDelete.setCellValueFactory(new PropertyValueFactory("Delete"));
    }
}

