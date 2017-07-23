package com.deepzai.models;

import com.deepzai.helper.javafx.JavaFXScale;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class KeyExistsScene {

    public void init(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/key_exists.fxml"));
        stage.setTitle("GitSSH");
        Scene scene =  new Scene(root, 640 ,480);

        JavaFXScale.setMaxRes(stage, new Dimension(640,480));
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }
}
