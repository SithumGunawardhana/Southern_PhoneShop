import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = this.getClass().getResource("/lk/shop/southernPhone/view/LoginForm.fxml");
        Parent window = FXMLLoader.load(resource);
        Scene scene=new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Southern Mobile");
        primaryStage.centerOnScreen();
        primaryStage.show();


    }
}
