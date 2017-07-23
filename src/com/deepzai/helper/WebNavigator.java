package com.deepzai.helper;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class WebNavigator {

    public static void openWebpage(URI uri) {
        // checks if desktop is supported, if true -> get desktop, if not -> set to null.
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
