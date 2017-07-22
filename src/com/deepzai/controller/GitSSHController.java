package com.deepzai.controller;

import com.deepzai.GitSSH;
import com.deepzai.helper.Alerts;
import com.deepzai.models.KeyExistsScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;

public class GitSSHController {

    private KeyExistsScene keyScene;
    PrintWriter writer;

    @FXML
    private Button generateSSH;

    @FXML
    public void generateSSH(ActionEvent event) throws IOException {
        if(!(System.getProperty("os.name").toLowerCase().contains("win"))) {
            Alerts.alert_err_OS();
        }

        if (GitSSH.id_rsa.exists()) {
            Alerts.alert_err_duplicateKey();
            Stage stage = (Stage) generateSSH.getScene().getWindow();
            keyScene.init(stage);
        }
    }

    public void initialize() throws Exception {
        keyScene = new KeyExistsScene(writer);
    }

}
