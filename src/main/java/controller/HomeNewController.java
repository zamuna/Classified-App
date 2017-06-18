package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

/**
 * Created by Zamuna on 6/16/2017.
 */
public class HomeNewController extends Application {

    // Creating a static root to pass to the controller
    private static BorderPane root = new BorderPane();

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // loading FXML resources
        // note that we don't need PaneTwo in this class

        URL menuBarUrl = getClass().getResource("/view/myMenus.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("/view/homeNew.fxml");
        AnchorPane paneOne;
        paneOne = FXMLLoader.load( paneOneUrl );

        // constructing our scene using the static root

        root.setTop(bar);
        root.setCenter(paneOne);

        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets()
                .add(getClass()
                        .getResource("/view/login.css")
                        .toExternalForm());


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    void sellYourItem(ActionEvent event) {

        try {

            URL paneOneUrl = getClass().getResource("/view/sellYourItem.fxml");
            AnchorPane paneOne = FXMLLoader.load( paneOneUrl);

            BorderPane border = HomeNewController.getRoot();
            border.setCenter(paneOne);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
