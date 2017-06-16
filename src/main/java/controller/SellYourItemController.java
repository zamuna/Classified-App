package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Zamuna on 6/14/2017.
 */
public class SellYourItemController extends Application{
    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtTitle;

    private Stage stage;
    private Label imgLabel=new Label("Image here");
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/sellYourItem.fxml"));
        Parent root=loader.load();
//        SellYourItemController controller=(SellYourItemController)loader.getController();
//        controller.init(primaryStage);
//        Parent root = FXMLLoader.load(getClass().getResource("/view/sellYourItem.fxml"));
        primaryStage.setTitle("Classified Ads ");
        primaryStage.setScene(new Scene(root, 800, 675));
//        root.getStylesheets().add(Main.class.getResource("/view/login.css").toExternalForm());
        primaryStage.show();
    }

    private void init(Stage primaryStage) {
        this.stage=primaryStage;
    }

    @FXML
    public  void openFile(){
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files","*.*"),
          new FileChooser.ExtensionFilter("jpeg","*.jpeg"),
                new FileChooser.ExtensionFilter("jpg","*.jpg"),
                new FileChooser.ExtensionFilter("png","*.png")

        );
        File file=fileChooser.showOpenDialog(stage);

        if(file!=null){
            System.out.println(file);
//            imgLabel.setText(file.getName());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
