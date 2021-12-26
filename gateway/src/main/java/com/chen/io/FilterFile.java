package com.chen.io;

import java.io.*;
import java.util.regex.Pattern;

public class FilterFile {

    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.isDirectory());
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern r = Pattern.compile(".");
                return r.matcher(name).matches();
            }
        });
        for (String str:
             list) {
            System.out.println(str);
        }
    }
}
