package controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Post;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

/**
 * Created by Zamuna on 6/16/2017.
 */
public class HomeNewController extends Application {
    @FXML
    private JFXTreeTableView<Post> treeTableView;

    @FXML
    private TitledPane titledPane;
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
        System.out.println("HomeNew Controller");
        URL menuBarUrl = getClass().getResource("/view/myMenus.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("/view/home.fxml");
        AnchorPane paneOne;
        paneOne = FXMLLoader.load( paneOneUrl );

        root.setTop(bar);
        root.setCenter(paneOne);

        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets()
                .add(getClass()
                        .getResource("/view/login.css")
                        .toExternalForm());

        titledPane=new TitledPane();
        TilePane tilePane=new TilePane();
        Label lbl=new Label("Hello");
        titledPane.setText("New One");
        getRoot().getChildren().add(lbl);

        primaryStage.setScene(scene);

        JFXTreeTableColumn<Post,String> jfxTreeTableColumn=new JFXTreeTableColumn<>("PostName");
        jfxTreeTableColumn.setPrefWidth(150);
        jfxTreeTableColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Post, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Post, String> param) {
                return (ObservableValue<String>) param.getValue();
            }
        });
        primaryStage.show();

        // constructing our scene using the static root


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

    public void showCategory(ActionEvent actionEvent) {
        try {
            URL paneOneUrl = getClass().getResource("/view/category.fxml");
            AnchorPane paneOne = FXMLLoader.load( paneOneUrl);

            BorderPane border = HomeNewController.getRoot();
            border.setCenter(paneOne);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void home(ActionEvent actionEvent) {
        try {
            URL paneOneUrl = getClass().getResource("/view/home.fxml");
            AnchorPane paneOne = FXMLLoader.load( paneOneUrl);

            BorderPane border = HomeNewController.getRoot();
            border.setCenter(paneOne);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
