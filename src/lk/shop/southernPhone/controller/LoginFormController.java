package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes;
import lk.shop.southernPhone.util.Routes2;

import java.awt.*;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField jfxtxtName;
    public JFXTextField jfxtxtPassWord;
    public JFXButton jxfbtnLogin;
    public JFXButton jfxbtnClear;
    public AnchorPane jfxbtnSupplier;
    public JFXButton jfxbtnCustomer;
    public JFXButton jfxbtnSupp;
    public JFXButton jfxbtnItem;
    public JFXButton jfxbtnRepair;
    public JFXButton jfxbtnPayment;
    public JFXButton jfxbtnDelevery;
    public JFXButton jfxbtnReturn;
    public JFXButton jfxbtnPlaceOrder;
    public JFXTextField jfxtxtUserName;


    public void LoginOnAction(ActionEvent actionEvent) throws Exception {
        if(jfxtxtUserName.getText().equals("Sithum")&& jfxtxtPassWord.getText().equals("Sithum1234")) {
            Navigation.navigate(Routes.DASHBOARD, pane);

       }else{

            new Alert(Alert.AlertType.WARNING,"User Name Or Password Incorrect ...").show();
            jfxtxtPassWord.clear();
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) throws Exception {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void SupplierOnAction(MouseEvent mouseEvent) {

    }

    public void CustomerOnAction(ActionEvent actionEvent) {
    }

    public void ItemOnAction(ActionEvent actionEvent) {
    }

    public void RepairOnAction(ActionEvent actionEvent) {
    }

    public void PaymentOnAction(ActionEvent actionEvent) {
    }

    public void DeliveryOnAction(ActionEvent actionEvent) {
    }

    public void ReturnOnAction(ActionEvent actionEvent) {
    }

    public void PlaceOrderOnAction(ActionEvent actionEvent) {
    }

    public void UserNameOnAction(ActionEvent actionEvent) {
    }

    public void PassWordOnAction(ActionEvent actionEvent) {
    }
}
