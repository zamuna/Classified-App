package controller;

import com.asd.framework.error.ErrorMessage;
import com.classified.login.ProxyLogin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.UserWithToken;
import service.UserService;

import java.util.HashMap;
import java.util.Map;


public class MainController extends Application {
     static String tokenGlobal="";
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
        UserService userService = new UserService(User.class);
        userWithToken = userService.login(new User(email, password));
        Map<String, String> map = new HashMap<>();
        System.out.println("New token"+((UserWithToken)userWithToken).getToken());
        tokenGlobal=((UserWithToken)userWithToken).getToken();
        System.out.println(tokenGlobal+"----");
        map.put("Authorization", "Bearer "+tokenGlobal);


        if (userWithToken != null) {
            System.out.println("Logged in successfully " + userWithToken);
            homeNewController = new HomeNewController();
            try {
                root = FXMLLoader.load(getClass().getResource("/view/homeNew.fxml"));
                Scene scene=new Scene(root);
                stage= (Stage) btnLogin.getScene().getWindow();
                stage.setScene(scene);
//                homeNewController.setToken(tokenGlobal);
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
       Object o = userService.insert(user);
        if (userService.isSuccess(o)){
             user =userService.getData(o);
        }else {
             java.util.List<ErrorMessage> em = userService.getErrorMsg(o);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
