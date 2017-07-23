package com.deepzai.helper.javafx;

import javafx.stage.Stage;

import java.awt.*;

public class JavaFXScale {

    public static void setMaxRes(Stage stage, Dimension dimension) {
        stage.setMaxWidth(dimension.getWidth());
        stage.setMaxHeight(dimension.getHeight());
    }
}
