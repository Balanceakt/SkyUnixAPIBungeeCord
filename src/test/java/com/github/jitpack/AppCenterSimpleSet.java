package com.github.jitpack;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class AppCenterSimpleSet
{
    public static void main(String[] args) {
        DBCenterSimpleDelete dbCenterDelete = new DBCenterSimpleDelete();
        DBCenterSimpleSet dbCenterSet = new DBCenterSimpleSet();
        DBCenterSimpleRead dbCenterRead = new DBCenterSimpleRead();
        DBCenterSimpleReadColorCode dbCenterSimpleReadColorCode = new DBCenterSimpleReadColorCode();

        //dbCenterSet.setSimpleArgValue("color", "red", "&4Test");

        //List<String> valuesList = Arrays.asList("spawn", "X", "Y", "Z");
        //dbCenterSet.setSimpleArgsValues("builder", "lobby", valuesList);

        //dbCenterDelete.deleteEntry("builder", "lobby");

        //System.out.println(dbCenterRead.readSimpleArgs("builder", "lobby", 0));

        //System.out.println(dbCenterSimpleReadColorCode.readColorCodes("color", "red", 0));
    }
}
