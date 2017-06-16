package controller;/**
 * Created by Zamuna on 6/15/2017.
 */

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Application{
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    public static void main(String[] args) {
    launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/home.fxml"));
        Parent root= loader.load();
        primaryStage.setTitle("Classified Ads Home ");
        primaryStage.setScene(new Scene(root, 900, 875));
        root.getStylesheets().add(Main.class.getResource("/view/login.css").toExternalForm());
        primaryStage.show();
    }

}
