package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Zamuna on 6/15/2017.
 */
public class LandingController extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/landingPage.fxml"));
        primaryStage.setTitle("Classified Ads ");
        primaryStage.setScene(new Scene(root, 800, 675));
        root.getStylesheets().add(Main.class.getResource("/view/login.css").toExternalForm());
        primaryStage.show();
    }
}
