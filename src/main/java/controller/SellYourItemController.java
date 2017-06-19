package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Post;
import model.User;
import service.PostService;
import service.UserService;

import javax.naming.Context;
import java.io.*;
import java.time.LocalDate;

/**
 * Created by Zamuna on 6/14/2017.
 */
public class SellYourItemController extends Application{
    @FXML
    private JFXTextField txtManufacture;

    @FXML
    private JFXComboBox<?> txtCategory;

    @FXML
    private JFXComboBox<?> txtStatus;

    @FXML
    private JFXButton btnAddItem;

    @FXML
    private Pane paneSellurItem;

    @FXML
    private JFXTextArea txtDetails;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXButton btnImageUpload;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    void sellYourItem(ActionEvent event) {
        String title="";
        String category="";
        String qty="";
        String details="";
        Integer status=0;
        String date ="";
        String url="";
        String price="";

        title=txtTitle.getText();
        category=txtCategory.getSelectionModel().getSelectedItem().toString();
        qty=txtQuantity.getText();
        details=txtDetails.getText();
        status= Integer.valueOf(txtStatus.getSelectionModel().getSelectedItem().toString());
        date=txtManufacture.getText();
        price=txtPrice.getText();
        System.out.println("Title"+title);
        System.out.println("CAtegory:"+category);
        System.out.println("Qty:"+qty);
        System.out.println("Details:"+details);
        System.out.println("Status:"+status);
        System.out.println("Date:"+date);
        System.out.println("url:"+url);
        Post post=new Post();
        post.setTitle(title);
        post.setDescription(details);
        post.setDateOfManufacture(LocalDate.parse(date));
        post.setPrice(Integer.parseInt(price));
        post.setUrl(url);
        post.setCategoryId(Long.parseLong(category));
        post.setStatus(((status==0) ? true : false));

    }

    private Stage stage;
    private Label imgLabel=new Label("Image here");
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/sellYourItem.fxml"));
        Parent root=loader.load();
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
        }

    }


    public Post submitData(){
        PostService postService=new PostService(Post.class);
        Post post=new Post();
        return post;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
