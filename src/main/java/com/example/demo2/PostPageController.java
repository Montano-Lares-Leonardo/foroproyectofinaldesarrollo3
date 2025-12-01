package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PostPageController {
    private Stage primaryStage;
    @FXML
    private Button autor;
    @FXML
    private Button borrar;
    @FXML
    private Button editar;
    @FXML
    private Button post;
    @FXML
    private Label date;
    @FXML
    private Label titulo;
    @FXML
    private Label body;
    @FXML
    private TextField search;
    private Post publicacion;
    @FXML
    private TableView<Post> tablaPosts;
    @FXML
    private TableColumn<Post, String> columnaTitle;
    @FXML
    private TableColumn<Post, String> columnaUser;
    @FXML
    private TableColumn<Post, String> columnaText;

    private ObservableList<Post> listaObservable;

    public void setPost(Post post) {
        publicacion = post;
        autor.setText(post.getUsername());
        date.setText(post.getDate());
        titulo.setText(post.getTitle());
        body.setText(post.getText());
        if (LoggedIn.getID() != 0) this.post.setDisable(false);
        else this.post.setDisable(true);
        if (LoggedIn.getID() == post.getUserID()) {
            borrar.setDisable(false);
            editar.setDisable(false);
        } else {
            borrar.setDisable(true);
            editar.setDisable(true);
        }

        listaObservable = FXCollections.observableArrayList(ManejadorDB.getPosts(" AND (p.post_parent_ID = " + post.getPostid() + ")"));
        tablaPosts.setItems(listaObservable);
        tablaPosts.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                cargarSeleccionado(newSel);
            }
        });
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    private void cargarSeleccionado(Post post) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainPageController.class.getResource("post-page.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 400, 400);

            PostPageController mainController = fxmlLoader.getController();
            mainController.setPost(post);

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

    @FXML
    public void initialize() {
        columnaTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columnaUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
        columnaText.setCellValueFactory(new PropertyValueFactory<>("Text"));
    }
}
