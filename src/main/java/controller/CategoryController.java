package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Category;
import model.Post;
import service.CategoryService;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zamuna on 6/19/2017.
 */
public class CategoryController extends Application {
    private static BorderPane root = new BorderPane();
    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXButton btnAddCategory;

    @FXML
    private JFXTextField txtCategoryName;



    @Override
    public void start(Stage primaryStage) throws Exception {
        // loading FXML resources
        // note that we don't need PaneTwo in this class
        System.out.println("Category Controller");
        URL menuBarUrl = getClass().getResource("/view/myMenus.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("/view/category.fxml");
        AnchorPane paneOne;
        paneOne = FXMLLoader.load( paneOneUrl );

        root.setTop(bar);
        root.setCenter(paneOne);

        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets()
                .add(getClass()
                        .getResource("/view/login.css")
                        .toExternalForm());

        primaryStage.setScene(scene);

        primaryStage.show();

        // constructing our scene using the static root


    }

    @FXML
    void saveCategory(ActionEvent event) {
        System.out.println("Category token "+MainController.tokenGlobal);
        String name="";
        String description="";

        name=txtCategoryName.getText();
        description=txtDescription.getText();

        CategoryService categoryService=new CategoryService(Category.class);
        Category category=new Category();
        category.setName(name);
        category.setDescription(description);
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer "+MainController.tokenGlobal);
        categoryService.setMap(map);
        categoryService.insert(category);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
