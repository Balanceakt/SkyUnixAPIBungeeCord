package com.github.jitpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBCenterSimpleConvertArgsWithColorCode {
    public DBCenterSimpleConvertArgsWithColorCode() {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        File folder = new File(DBCenterFilePath.folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created: " + DBCenterFilePath.folderPath);
            } else {
                System.err.println("Failed to create folder: " + DBCenterFilePath.folderPath);
            }
        }
    }

    public String readColorCodes(String table, String key, int argIndex) {
        File settingFile = new File(DBCenterFilePath.folderPath, table);
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);

            String value = properties.getProperty(key);

            String[] valuesArray = value.split(",");

            if (argIndex >= 0 && argIndex < valuesArray.length) {
                return convertColorCodes(valuesArray[argIndex]);
            } else {
                System.out.println("Index out of range for key: " + key);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String convertColorCodes(String input) {
        return input.replace("&", "§");
    }
}