package com.example.sixquiprend.Controller;

import com.example.sixquiprend.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BaseController {
    @FXML
    protected AnchorPane stageAP, screenElements;

    @FXML
    protected ImageView background;

    protected boolean isInit = false;


    protected void loadPage(String pageName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(/*"fxml/"+ */pageName + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((Stage) stageAP.getScene().getWindow()).setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Image setAnImage(String path) {
        try {
            return new Image(Objects.requireNonNull(HelloApplication.class.getResource(path)).openStream());
        } catch (IOException | NullPointerException | IllegalArgumentException ignored) {
            System.out.println("Erreur d'affichage : " + path);
            return BaseController.setAnImage("Images/error.png");
        }
    }


}
