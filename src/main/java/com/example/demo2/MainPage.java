package com.example.demo2;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainPage {
    @FXML private TextField search;
    @FXML private Button login;
    @FXML private Button post;
    @FXML private TableView<Post> tablaPosts;
    @FXML private TableColumn<Post, String> columnaTitle;
    @FXML private TableColumn<Post, String> columnaUser;
    @FXML private TableColumn<Post, String> columnaText;

    private ObservableList<Post> listaObservable;
    private ManejadorDB manejadorDB;
}
