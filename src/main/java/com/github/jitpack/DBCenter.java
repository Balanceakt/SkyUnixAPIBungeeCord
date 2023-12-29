package com.github.jitpack;

public class DBCenter {

    public static void main(String[] args) {
        init();
        System.out.println("DBCenter wird gestartet...");
    }

    public static void init() {
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

    private static void registerClass(Object instance) {
        System.out.println("Klasse registriert: " + instance.getClass().getName());
        // Hier kannst du weitere Aktionen für die registrierten Klassen durchführen
    }
}
