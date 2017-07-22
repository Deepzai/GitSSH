package com.deepzai.helper;

import javafx.stage.Stage;

import java.awt.*;

public class JavaFXScale {

    public static void setMaxRes(Stage stage, Dimension dimension) {
        stage.setMaxWidth(dimension.getWidth());
        stage.setMaxHeight(dimension.getHeight());
    }
}
