package com.deepzai;

import com.deepzai.helper.VersionChecker;
import com.deepzai.models.InitialScene;

import javafx.application.Application;

import javafx.stage.Stage;

import java.io.File;

public class GitSSH extends Application {

    public static final String current_version = "v0.0.1";
    public static final String latest_version = "https://raw.githubusercontent.com/Deepzai/GitSSH/validator/latest.ver";
    public static final File id_rsa = new File(System.getProperty("user.home") + '\\' + ".ssh" + '\\' + "id_rsa.pub");

    @Override
    public void start(Stage primaryStage) throws Exception {
        InitialScene.init(primaryStage);
        VersionChecker.check(latest_version);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
