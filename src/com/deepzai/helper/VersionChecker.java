package com.deepzai.helper;

import com.deepzai.GitSSH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class VersionChecker {

    /**
     *  Checks uses version link as supplied by com.deepzai.GitSSH
     * */
    public static void check(String url) throws IOException {
        String new_version = grabURL(url);
        if (GitSSH.current_version != new_version)) {
            return;
        } else {
            return;
        }
    }

    public static String grabURL(String url) throws IOException {
        URL inputStream = new URL(url);
        StringBuilder version = new StringBuilder(8);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream.openStream()));
        String input;

        while ((input = in.readLine()) != null) {
            version.append(input);
        }
        in.close();
        return version.toString().trim();
    }

    public static String grabURL(URL url) throws IOException {
        String url_str = url.toString();
        return grabURL(url_str);
    }
}
