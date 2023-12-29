package com.github.jitpack;

import utils.FilePath;

import java.io.*;
import java.util.Properties;

public class DBCenterSimpleDelete {
    public void deleteEntry(final String settingName, final String key) {
        File settingFile = new File(FilePath.folderPath, settingName);
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
}
