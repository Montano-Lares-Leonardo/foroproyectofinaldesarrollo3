package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageAplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageAplication.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 472);
        primaryStage.setTitle("Pagina Principal");
        //primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icono.PNG"))));
        primaryStage.setScene(scene);
        primaryStage.show();

        //Controlador del login
        MainPageController controller = fxmlLoader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }

}