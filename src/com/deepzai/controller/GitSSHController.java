package com.deepzai.controller;

import com.deepzai.GitSSH;
import com.deepzai.helper.Alerts;
import com.deepzai.helper.GitValidator;
import com.deepzai.models.KeyExistsScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GitSSHController {

    private KeyExistsScene keyScene;

    @FXML
    private Button generateSSH;

    @FXML
    public void generateSSH(ActionEvent event) throws IOException {
        if(!System.getProperty("os.name").toLowerCase().contains("win")) {
            Alerts.alert_err_OS();
        }

        if(!GitValidator.isGitInstalled()) {
            System.out.println(GitValidator.git_bash_path);
            Alerts.alert_err_gitNotFound();
            return;
        }

        if (GitSSH.id_rsa.exists()) {
            Alerts.alert_err_duplicateKey();
            if (!Alerts.exitCode_duplicateKey) {
                Stage stage = (Stage) generateSSH.getScene().getWindow();
                keyScene.init(stage);
            }
            return;
        }
    }

    public void initialize() throws Exception {
        keyScene = new KeyExistsScene();
    }

}
