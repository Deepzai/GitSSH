package com.deepzai.helper;

import javafx.scene.Scene;

public class SceneHelper {

    public static Scene activeScene;

    public static Scene getActiveScene() {
        return activeScene;
    }

    public static void setActiveScene(Scene scene) {
        activeScene = scene;
    }
}
