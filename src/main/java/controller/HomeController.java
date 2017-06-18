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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Application{
    private static BorderPane root = new BorderPane();

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL menuBarUrl = getClass().getResource("/view/myMenus.fxml");
        javafx.scene.control.MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("/view/home.fxml");
        AnchorPane paneOne = FXMLLoader.load( paneOneUrl );

        root.setTop(bar);
        root.setCenter(paneOne);

        primaryStage.setTitle("Classified Ads Home ");
        Scene scene=new Scene(root, 900, 875);
        primaryStage.setScene(scene);

        root.getStylesheets().add(Main.class.getResource("/view/login.css").toExternalForm());

        primaryStage.show();
    }

}
