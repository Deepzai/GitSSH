package com.deepzai.helper;

import com.deepzai.GitSSH;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class Alerts {

    public static boolean exitCode_duplicateKey = false;

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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("GitSSH - Duplicate Key");
        alert.setHeaderText("A key has already been found: " + GitSSH.id_rsa.getPath());
        alert.setContentText("You have the option of viewing the existing key.");

        //ButtonType show = new ButtonType("Show Key");

        //alert.getButtonTypes().setAll(show);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            exitCode_duplicateKey = false;
        } else {
            exitCode_duplicateKey = true;
        }
    }

    public static void alert_err_gitNotFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("GitSSH - Dependencies Missing");
        alert.setHeaderText("Git doesn't seem to be installed on your system!");
        alert.setContentText("Click Download to be directed to the download page for git.");

        ButtonType downloadGit = new ButtonType("Download");

        alert.getButtonTypes().setAll(downloadGit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == downloadGit) {
            try {
                WebNavigator.openWebpage(new URI(GitValidator.git_dl_url));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    public static void alert_minor_newVersion(String new_version) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("GitSSH - New oVersion Found");
        alert.setHeaderText("You seem to be using an outdated version. Your current version: " + GitSSH.current_version);
        alert.setContentText("The latest version is currently " + new_version);

        // add download button for new version
    }
}
