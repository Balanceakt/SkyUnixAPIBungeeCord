package com.github.jitpack;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.spi.CollatorProvider;

public class DBCenter extends JavaPlugin {

    private static Plugin pluginInstance;
    public static void setPluginInstance(Plugin plugin) {
        pluginInstance = plugin;
    }
    public static Plugin getPlugin() {
        return pluginInstance;
    }

    @Override
    public void onEnable() {
        init();
        getLogger().info("DBCenter wird gestartet...");
    }

    @Override
    public void onDisable() {
        getLogger().info("DBCenter wird gestoppt...");
    }

    private void init() {
        DBCenterSimpleConvertArgsWithColorCode simpleSetConvertArgs = new DBCenterSimpleConvertArgsWithColorCode();
        DBCenterSimpleDelete simpleDelete = new DBCenterSimpleDelete();
        DBCenterSimpleLocation simpleLocation = new DBCenterSimpleLocation();
        DBCenterSimpleSetArgs simpleSetArgs = new DBCenterSimpleSetArgs();
        DBCenterSimpleReadArgs simpleReadArgs = new DBCenterSimpleReadArgs();

        registerClass(simpleSetArgs);
        registerClass(simpleDelete);
        registerClass(simpleLocation);
        registerClass(simpleSetConvertArgs);
        registerClass(simpleReadArgs);
    }

    private void registerClass(Object instance) {
        getLogger().info("Klasse registriert: " + instance.getClass().getName());
    }
}
