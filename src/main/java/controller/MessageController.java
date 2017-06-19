package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Category;
import model.Message;
import service.CategoryService;
import service.MessageService;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zamuna on 6/19/2017.
 */
public class MessageController extends Application {
    private static BorderPane root = new BorderPane();
    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @FXML
    private JFXTextField txtMessage;

    @FXML
    private JFXButton btnSendMessage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // loading FXML resources
        // note that we don't need PaneTwo in this class
        System.out.println("Message Controller");
        URL menuBarUrl = getClass().getResource("/view/myMenus.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        URL paneOneUrl = getClass().getResource("/view/message.fxml");
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
    void saveMessage(ActionEvent event) {
        System.out.println("Message token "+MainController.tokenGlobal);
        String msg="";

        msg=txtMessage.getText();

        MessageService messageService=new MessageService(Message.class);
        Message message=new Message();
        message.setText(msg);
        message.setSenderId(1L);
        message.setReceiverId(1L);
        message.setRead(false);
        Map<String, String> map = new HashMap<>();
//        map.put("Authorization", "Bearer "+MainController.tokenGlobal);
        map.put("Authorization","Bearer 7e14a8efe0ca48b0aef9688ea08f791c");
        messageService.setMap(map);
        messageService.insert(message);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
