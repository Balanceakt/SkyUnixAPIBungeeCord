package com.github.jitpack;

import java.io.*;
import java.util.Properties;

public class DBCenterSimpleDelete {
    public void deleteEntry(final String table, final String key) {
        File settingFile = new File(DBCenterFilePath.folderPath, table);
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.remove(key);
        try (OutputStream output = new FileOutputStream(settingFile)) {
            properties.store(output, "Updated by deleteEntry method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(final String table) {
        File fileToDelete = new File(DBCenterFilePath.folderPath, table);

        try {
            if (fileToDelete.exists() && fileToDelete.delete()) {
                System.out.println("File deleted: " + fileToDelete.getAbsolutePath());
            } else {
                System.err.println("Failed to delete file: " + fileToDelete.getAbsolutePath());
            }
        } catch (SecurityException e) {
            System.err.println("SecurityException: " + e.getMessage());
        }
    }
}
