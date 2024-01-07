package test;

import api.SkyUnixHandleArgs;

public class TestSkyUnixApi {

    private static SkyUnixHandleArgs argsTest = new SkyUnixHandleArgs();
    public static SkyUnixHandleArgs getArgsTest() {
        argsTest.setSimpleArgValue("skyblock", "prefix", "prefixTEST4", "Hallo4");
        return argsTest;
    }

    public static void main(String[] args) {
        SkyUnixHandleArgs result = getArgsTest();
        System.out.println("SkyUnixAPI instance created: " + result);
    }
}
