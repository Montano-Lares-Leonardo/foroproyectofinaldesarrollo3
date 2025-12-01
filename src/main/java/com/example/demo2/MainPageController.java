package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    private Stage primaryStage;
    @FXML private TextField search;
    @FXML private Button login;
    @FXML private Button post;
    @FXML private Button notif;
    @FXML private TableView<Post> tablaPosts;
    @FXML private TableColumn<Post, String> columnaTitle;
    @FXML private TableColumn<Post, String> columnaUser;
    @FXML private TableColumn<Post, String> columnaText;

    private ObservableList<Post> listaObservable;

    @FXML
    public void initialize() {
        columnaTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columnaUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
        columnaText.setCellValueFactory(new PropertyValueFactory<>("Text"));

        listaObservable = FXCollections.observableArrayList(ManejadorDB.getPosts(" AND (p.post_parent_ID IS NULL)"));
        tablaPosts.setItems(listaObservable);
        tablaPosts.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                cargarSeleccionado(newSel);
            }
        });
    }

    private void cargarSeleccionado(Post post) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainPageController.class.getResource("post-page.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 400, 400);

            PostPageController postController = fxmlLoader.getController();
            postController.setPrimaryStage(primaryStage);
            postController.setPost(post);

            //crear la subventana
            Stage mainStage = new Stage();
            mainStage.setTitle(post.getTitle());

            //mainStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icono.PNG"))));
            mainStage.setScene(mainScene);
            mainStage.setX(primaryStage.getX() + 80);
            mainStage.setY(primaryStage.getY() + 20);
            mainStage.initOwner(primaryStage);
            mainStage.initModality(Modality.WINDOW_MODAL);
            mainStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
}
