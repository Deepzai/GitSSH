package com.deepzai.helper;

import com.deepzai.GitSSH;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {

    public static void alert_err_OS() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("GitSSH - Incompatible OS");
        alert.setHeaderText("It seems like you are using: (" + System.getProperty("os.name") + ")");
        alert.setContentText("We only support Windows platforms as of right now. Sorry!");

        ButtonType buttonTypeCancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        System.exit(0);
    }

    public static void alert_err_duplicateKey() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("GitSSH - Duplicate Key");
        alert.setHeaderText("A key has already been found: " + GitSSH.id_rsa.getPath());
        alert.setContentText("You have the option of viewing the existing key.");

        ButtonType show = new ButtonType("Show Key");

        alert.getButtonTypes().setAll(show);

        Optional<ButtonType> result = alert.showAndWait();
    }
}
