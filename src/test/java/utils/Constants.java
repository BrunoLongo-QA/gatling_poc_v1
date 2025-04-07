package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final int TIMEOUT = 5000;
    public static String REQRES_BASE_URL = "https://reqres.in/";
    public static final Map<String, String> REQRES_HEADERS;
    static {
        Map<String, String> headers = new HashMap<>();
        headers.put("sec-ch-ua", "\"Google Chrome\\\";v=\\\"135\\\", \\\"Not-A.Brand\\\";v=\\\"8\\\", \\\"Chromium\\\";v=\\\"135\\\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("sec-ch-ua-platform", "Windows");
        REQRES_HEADERS = Collections.unmodifiableMap(headers);
    }
    public static final Map<String, String> REQRES_ENDPOINTS;
    static {
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("users", "api/users");
        endpoints.put("unknown", "api/unknown");
        REQRES_ENDPOINTS = Collections.unmodifiableMap(endpoints);
    }
}
