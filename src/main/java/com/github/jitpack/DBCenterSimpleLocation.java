package com.github.jitpack;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

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

        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String locationKey = key + "." + properties.size(); // Eindeutiger Schlüssel für die Location

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
    }

    public Location loadLocation(String table, String key) {
        File settingFile = new File(DBCenterFilePath.folderPath, table);
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(settingFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        String worldName = properties.getProperty(key + ".world");
        double x = Double.parseDouble(properties.getProperty(key + ".x"));
        double y = Double.parseDouble(properties.getProperty(key + ".y"));
        double z = Double.parseDouble(properties.getProperty(key + ".z"));
        float yaw = Float.parseFloat(properties.getProperty(key + ".yaw"));
        float pitch = Float.parseFloat(properties.getProperty(key + ".pitch"));

        System.out.println("Loaded data:");
        System.out.println("worldName: " + worldName);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("yaw: " + yaw);
        System.out.println("pitch: " + pitch);

        World world = Bukkit.getWorld(worldName);

        if (world == null) {
            System.err.println("World not found: " + worldName);
            return null;
        }

        return new Location(world, x, y, z, yaw, pitch);
    }
}
