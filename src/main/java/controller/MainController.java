package controller;

import com.classified.login.ProxyLogin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import service.PostService;
import service.UserService;

import javax.naming.Context;
import java.awt.*;


public class MainController extends Application {

    private HomeNewController homeNewController;
    Stage stage;
    Parent root;
    @FXML
    private JFXTextField txtNameSignUp;

    @FXML
    private JFXPasswordField txtPasswordSignUp;

    @FXML
    private JFXTextField txtPhoneSignUp;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtEmailSignUp;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXPasswordField txtPswdLogin;

    @FXML
    private JFXTextField txtEmailLogin;

    @Override
    public void start(Stage primaryStage) throws Exception{

       root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        primaryStage.setTitle("Classified Ads ");
        primaryStage.setScene(new Scene(root, 800, 675));
        root.getStylesheets().add(MainController.class.getResource("/view/login.css").toExternalForm());
        primaryStage.show();
    }
    @FXML
    void login(ActionEvent event) {
        System.out.println("Logged in");
        String email = "";
        String password = "";
        Object userWithToken = null;
        email = txtEmailLogin.getText();
        password = txtPswdLogin.getText();
        ProxyLogin proxyLogin = new ProxyLogin();
        userWithToken = proxyLogin.login(email, password);
        if (userWithToken != null) {
            System.out.println("Logged in successfully " + userWithToken);
            homeNewController = new HomeNewController();
            try {
                root = FXMLLoader.load(getClass().getResource("/view/homeNew.fxml"));
                Scene scene=new Scene(root);
                stage= (Stage) btnLogin.getScene().getWindow();
                stage.setScene(scene);
                homeNewController.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @FXML
    void signUp(ActionEvent event) {
        System.out.println("sign up called");
        String uname="";
        String email="";
        String password="";
        String phNo="";
        uname=txtNameSignUp.getText();
        email=txtEmailSignUp.getText();
        password=txtPasswordSignUp.getText();
        phNo=txtPhoneSignUp.getText();
        UserService userService=new UserService(User.class);
        User user=new User();
        user.setName(uname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phNo);
        User userNew = userService.insertUser(user);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
