package com.deepzai.helper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHelper {

    public static String FILE_TO_STRING(File file) throws IOException {
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
}
