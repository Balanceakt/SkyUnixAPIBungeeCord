package com.github.jitpack;

public class AppCenterSimpleSet
{
    public static void main(String[] args) {
        DBCenterSimpleDelete dbCenterDelete = new DBCenterSimpleDelete();
        DBCenterSimpleSetArgs dbCenterSet = new DBCenterSimpleSetArgs();
        DBCenterSimpleReadArgs dbCenterRead = new DBCenterSimpleReadArgs();
        DBCenterSimpleConvertArgsWithColorCode dbCenterSimpleReadColorCode = new DBCenterSimpleConvertArgsWithColorCode();
        DBCenterSimpleLocation dbCenterSimpleLocation = new DBCenterSimpleLocation();

        //dbCenterSet.setSimpleArgValue("color", "red", "&4Test");

        //List<String> valuesList = Arrays.asList("spawn", "X", "Y", "Z");
        //dbCenterSet.setSimpleArgsValues("builder", "lobby", valuesList);

        //dbCenterDelete.deleteEntry("builder", "lobby");
        //dbCenterDelete.deleteFile("builder");

        //System.out.println(dbCenterRead.readSimpleArgs("builder", "lobby", 0));
        //System.out.println(dbCenterSimpleReadColorCode.readColorCodes("color", "red", 0));
    }
}
