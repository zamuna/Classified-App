package jfxtreetableview;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TreeItem;
import model.Post;
import service.PostService;

public class FXMLDocumentController implements Initializable {

    @FXML
    private FlowPane main;

    @FXML
    private JFXTreeTableView<PostItem> treeView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<PostItem, String> deptName = new JFXTreeTableColumn<>("Title");
        deptName.setPrefWidth(150);
        deptName.setCellValueFactory(param -> param.getValue().getValue().title);

        JFXTreeTableColumn<PostItem, Number> ageCol = new JFXTreeTableColumn<>("Price");
        ageCol.setPrefWidth(150);
        ageCol.setCellValueFactory(param -> param.getValue().getValue().price);

        JFXTreeTableColumn<PostItem, String> nameCol = new JFXTreeTableColumn<>("Description");
        nameCol.setPrefWidth(150);
        nameCol.setCellValueFactory(param -> param.getValue().getValue().description);

        ObservableList<PostItem> users = FXCollections.observableArrayList();

        Map<String, String> map = new HashMap<>();
        String token = "ac59789228894429a678be5f4e2e6a85";
        map.put("Authorization", "Bearer "+token);
        PostService postService = new PostService(Post.class);
        postService.setMap(map);
        postService.getAllData(null,null, null, null).forEach(post -> users.add(new PostItem(
            post.getId(), post.getCategoryId(), post.getUserId(), post.getTitle(),
            post.getPrice(), post.getDescription(), post.getNegotiable(), post.getStatus(),
            post.getUrl()
        )));

        final TreeItem<PostItem> root = new RecursiveTreeItem<PostItem>(users, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(deptName, ageCol, nameCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);

    }

    @FXML
    private void filter(ActionEvent event) {
    }

    class PostItem extends RecursiveTreeObject<PostItem> {
        private LongProperty id;
        private LongProperty categoryId;
        private LongProperty userId;
        private StringProperty title;
        private IntegerProperty price;
        private StringProperty description;
        private BooleanProperty negotiable;
        private BooleanProperty status;
        private StringProperty url;

        public PostItem(Long id, Long categoryId, Long userId, String title,
                        Integer price, String description, Boolean negotiable,
                        Boolean status, String url) {
            this.id = new SimpleLongProperty(id);
            this.categoryId = new SimpleLongProperty(categoryId);
            this.userId = new SimpleLongProperty(userId);
            this.title = new SimpleStringProperty(title);
            this.price = new SimpleIntegerProperty(price);
            this.description = new SimpleStringProperty(description);
            this.negotiable = new SimpleBooleanProperty(negotiable);
            this.status = new SimpleBooleanProperty(status);
            this.url = new SimpleStringProperty(url);
        }

    }
}
