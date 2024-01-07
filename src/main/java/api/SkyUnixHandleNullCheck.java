package api;

import utils.FilePath;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SkyUnixHandleNullCheck {

    public static boolean isFolderExists(String folder) {
        File folderFile = new File(FilePath.folderPath, folder);
        return folderFile.exists() && folderFile.isDirectory();
    }

    public static boolean isTableExists(String folder, String table) {
        File folderFile = new File(FilePath.folderPath, folder);
        File settingFile = new File(folderFile, table);
        return folderFile.exists() && settingFile.exists();
    }

    public static boolean isKeyExists(String folder, String table, String key) {
        File folderFile = new File(FilePath.folderPath, folder);
        File settingFile = new File(folderFile, table);
        Properties properties = new Properties();
        if (!folderFile.exists() || !settingFile.exists()) {
            return false;
        }
        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
            String value = properties.getProperty(key);
            return value != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isValueExists(String folder, String table, String key, int indexToCheck) {
        File folderFile = new File(FilePath.folderPath, folder);
        File settingFile = new File(folderFile, table);
        Properties properties = new Properties();
        if (!folderFile.exists() || !settingFile.exists()) {
            return false;
        }
        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
            String existingValues = properties.getProperty(key);
            if (existingValues != null) {
                List<String> currentValues = new ArrayList<>(Arrays.asList(existingValues.split(",")));
                return indexToCheck >= 0 && indexToCheck < currentValues.size();
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
