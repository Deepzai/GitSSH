package com.deepzai.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitValidator {

    public static String git_bash_path = "";
    public static final String git_dl_url = "https://git-scm.com/downloads";

    public static boolean isGitInstalled() throws IOException {
        boolean git = false;

        Runtime rt = Runtime.getRuntime();
        String cmd = "where git";
        Process proc = rt.exec(cmd);

        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        String output = null;
        while ((output = input.readLine()) != null) {
            if (output.toLowerCase().contains("git")) {
                git_bash_path = output;
                git = true;
            } else {
                git = false;
            }
        }
        while ((output = error.readLine()) != null) {
            git = false;
        }
        return git;
    }
}
