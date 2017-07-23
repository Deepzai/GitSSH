package com.deepzai.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ContentParser {

    public static String FILE_TO_CONTENT(File file) throws IOException {
        final String br = System.getProperty("line.separator");

        List<String> lines = Files.readAllLines(Paths.get(file.toURI()),
                Charset.defaultCharset());

        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            sb.append(line).append(br);
        }
        final String content = sb.toString();
        return content;
    }

    public static String URL_TO_CONTENT(URL website) throws Exception {
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }

}
