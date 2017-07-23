package com.deepzai.models;

import com.deepzai.GitSSH;
import com.deepzai.helper.javafx.JavaFXScale;
import com.deepzai.helper.javafx.SceneHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class InitialScene {

    public static void init(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(GitSSH.class.getResource("models/fxml/gitssh.fxml"));
        primaryStage.setTitle("GitSSH");
        Scene primary = new Scene(root, 640, 480);

        SceneHelper.setActiveScene(primary);
        primaryStage.setScene(SceneHelper.getActiveScene());

        JavaFXScale.setMaxRes(primaryStage, new Dimension(640,480));
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}
