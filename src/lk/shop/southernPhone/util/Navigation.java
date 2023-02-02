package lk.shop.southernPhone.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    private static AnchorPane pane2;


    public static void navigate2(Routes2 route2,AnchorPane pane2) throws IOException {
        Navigation.pane2=pane2;
        Navigation.pane2.getChildren().clear();
        Stage window2=(Stage) Navigation.pane2.getScene().getWindow();

        switch (route2){
            case WELCOME:
                iniUI2("WelcomeForm.fxml");
                break;


            case CUSTOMER:
                window2.setTitle("Customer Form");
                iniUI2("CustomerForm.fxml");
                break;

            case SUPPLIER:
                window2.setTitle("Supplier Form");
                iniUI2("SupplierForm.fxml");
                break;

            case ITEM:
                window2.setTitle("Item Form");
                iniUI2("ItemForm.fxml");
                break;

            case REPAIR:
                window2.setTitle("Repair Form");
                iniUI2("RepairForm.fxml");
                break;

            case DELIVERY:
                window2.setTitle("Delivery Form");
                iniUI2("DeliveryForm.fxml");
                break;

            case PAYMENT:
                window2.setTitle("Payment Form");
                iniUI2("PaymentForm.fxml");
                break;

            case RETURN:
                window2.setTitle("Return Form");
                iniUI2("ReturnForm.fxml");
                break;

            case PLACE_ORDER:
                window2.setTitle("Place Order Form");
                iniUI2("PlaceOrderForm.fxml");
                break;


        }
    }
    public static void navigate(Routes route,AnchorPane pane)throws Exception {
        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window=(Stage) Navigation.pane.getScene().getWindow();

        switch (route){
            case LOGIN:
                window.setTitle("Southern Mobile");
                iniUI("LoginForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("Southern Mobile");
                iniUI("DashBoardForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR,"Not suitable UI found!").show();
        }
    }

    private static void iniUI2(String location) throws IOException {
        Navigation.pane2.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/shop/southernPhone/view/"+location)));
    }


    private static void iniUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/shop/southernPhone/view/"+location)));
    }


}
