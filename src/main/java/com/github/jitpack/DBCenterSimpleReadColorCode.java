package com.github.jitpack;

import utils.FilePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBCenterSimpleReadColorCode {
    public DBCenterSimpleReadColorCode() {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        File folder = new File(FilePath.folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created: " + FilePath.folderPath);
            } else {
                System.err.println("Failed to create folder: " + FilePath.folderPath);
            }
        }
    }

    public String readColorCodes(String settingName, String key, int argIndex) {
        File settingFile = new File(FilePath.folderPath, settingName);
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