package lk.shop.southernPhone.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.shop.southernPhone.util.Navigation;
import lk.shop.southernPhone.util.Routes;
import lk.shop.southernPhone.util.Routes2;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane pane;
    public AnchorPane jfxbtnSupplier;
    public JFXButton jfxbtnCustomer;
    public JFXButton jfxbtnSupp;
    public JFXButton jfxbtnItem;
    public JFXButton jfxbtnRepair;
    public JFXButton jfxbtnPayment;

    public JFXButton jfxbtnDelivery;
    public JFXButton jfxbtnReturn;
    public JFXButton jfxbtnPlaceOrder;
    public JFXButton jfxbtnLogOut;
    public AnchorPane pane2;
    public TextField txtInStoke;
    public TextField txtMonthlyProfit;
    public TextField txtYearlyReport;
    public Button btnMonthlyReport;
    public Button btnYearlyReport;


    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.CUSTOMER,pane2);
    }

    public void ItemOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.ITEM,pane2);


    }

    public void RepairOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.REPAIR,pane2);

    }

    public void PaymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.PAYMENT,pane2);
    }

    public void DeliveryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.DELIVERY,pane2);
    }

    public void ReturnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.RETURN,pane2);
    }

    public void PlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.PLACE_ORDER,pane2);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws Exception {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void SupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate2(Routes2.SUPPLIER,pane2);
    }

    public void MonthlyReportOnAction(ActionEvent actionEvent) {
    }

    public void YearlyReportOnAction(ActionEvent actionEvent) {
    }
}
