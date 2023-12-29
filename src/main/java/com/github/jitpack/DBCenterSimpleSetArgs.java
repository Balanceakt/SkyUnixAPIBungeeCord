package com.github.jitpack;

import utils.FilePath;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class DBCenterSimpleSetArgs {
    public DBCenterSimpleSetArgs() {
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
    public void setSimpleArgValue(final String table, final String key, final String value) {
        File settingFile = new File(FilePath.folderPath, table);
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.setProperty(key, value);

        try (OutputStream output = new FileOutputStream(settingFile)) {
            properties.store(output, "Updated by setSetting method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setSimpleArgsValues(final String table, final String key, final List<String> values) {
        File settingFile = new File(FilePath.folderPath, table);
        Properties properties = new Properties();

        if (!settingFile.exists()) {
            try {
                if (settingFile.createNewFile()) {
                    System.out.println("File created: " + settingFile.getAbsolutePath());
                } else {
                    System.err.println("Failed to create file: " + settingFile.getAbsolutePath());
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
            properties.setProperty(key, String.join(",", values));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream output = new FileOutputStream(settingFile)) {
            properties.store(output, "Updated by setSimpleArgsValues method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}