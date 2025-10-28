package com.SpaceFinders.Sprint_2.Utility;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class IpUtility {

    public static String extractIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        System.out.println("His is also ip: " + ip);
        if(ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        if(ip != null && ip.contains(",")){
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }

    public static int sendOtp(String receiverIp, int port, String text, boolean raw) throws IOException {
        String url = "http://" + receiverIp + ":" + port + "/receive";
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) URI.create(url).toURL().openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");

        if (raw) {
            conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
        } else {
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            text = "text=" + java.net.URLEncoder.encode(text, StandardCharsets.UTF_8);
        }

        byte[] payload = text.getBytes(StandardCharsets.UTF_8);
        conn.setFixedLengthStreamingMode(payload.length);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(payload);
        }

        int code = conn.getResponseCode();
        System.out.println("[Sender] POST " + url + " -> HTTP " + code);
        conn.disconnect();
        return code;
    }
}
