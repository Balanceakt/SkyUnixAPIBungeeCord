package com.github.jitpack;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.*;
import java.util.Properties;

public class DBCenterSimpleLocation {
    public DBCenterSimpleLocation() {
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

    public void saveLocation(String table, String key, Location location) {
        File settingFile = new File(DBCenterFilePath.folderPath, table);
        Properties properties = new Properties();
        try {
            if (!settingFile.exists()) {
                if (settingFile.createNewFile()) {
                    System.out.println("File created: " + settingFile.getPath());
                } else {
                    System.err.println("Failed to create file: " + settingFile.getPath());
                }
            }
            try (InputStream input = new FileInputStream(settingFile)) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String locationKey = key;
            properties.setProperty(locationKey + ".world", location.getWorld().getName());
            properties.setProperty(locationKey + ".x", String.valueOf(location.getX()));
            properties.setProperty(locationKey + ".y", String.valueOf(location.getY()));
            properties.setProperty(locationKey + ".z", String.valueOf(location.getZ()));
            properties.setProperty(locationKey + ".yaw", String.valueOf(location.getYaw()));
            properties.setProperty(locationKey + ".pitch", String.valueOf(location.getPitch()));
            try (OutputStream output = new FileOutputStream(settingFile)) {
                properties.store(output, "Updated by saveLocation method");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Location loadLocation(String table, String key) {
        File settingFile = new File(DBCenterFilePath.folderPath, table);
        Properties properties = new Properties();

        if (!settingFile.exists()) {
            System.err.println("File not found: " + settingFile.getPath());
            return null;
        }
        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Loaded from file: " + settingFile.getAbsolutePath());
        System.out.println("Existing properties:");
        properties.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
        String locationKey = key;
        double x = Double.parseDouble(properties.getProperty(locationKey + ".x"));
        double y = Double.parseDouble(properties.getProperty(locationKey + ".y"));
        double z = Double.parseDouble(properties.getProperty(locationKey + ".z"));
        float yaw = Float.parseFloat(properties.getProperty(locationKey + ".yaw"));
        float pitch = Float.parseFloat(properties.getProperty(locationKey + ".pitch"));
        String worldName = properties.getProperty(locationKey + ".world");
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            return new Location(world, x, y, z, yaw, pitch);
        } else {
            System.err.println("World not found: " + worldName);
            return null;
        }
    }
}
