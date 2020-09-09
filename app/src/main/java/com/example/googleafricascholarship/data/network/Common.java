package com.example.googleafricascholarship.data.network;

public class Common {
    private static String baseUrl = "http://gadsapi.herokuapp.com/";
    private static String baseUrl1= "https://docs.google.com/forms/d/e/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        Common.baseUrl = baseUrl;
    }

    public static String getBaseUrl1() {
        return baseUrl1;
    }

    public static void setBaseUrl1(String baseUrl1) {
        Common.baseUrl1 = baseUrl1;
    }
}
