package com.util;

import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;

public class HttpsUtils {

    public static String doPost(String url, Proxy proxy, String params) throws Exception {
        System.out.println(params);
        // 设置代理
        HttpsURLConnection connection;
        if (proxy == null) {
            connection = (HttpsURLConnection) new URL(url).openConnection();
        } else {
            connection = (HttpsURLConnection) new URL(url).openConnection(proxy);
        }
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer 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");
        connection.setDoOutput(true);
        // 向请求正文中写入数据
        try (OutputStream outputStream = connection.getOutputStream();) {
            outputStream.write(params.getBytes());
            outputStream.flush();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
        }
        System.out.println("stringBuilder:" + stringBuilder);
        return stringBuilder.toString();
    }

//    public static String doGet(String url, Proxy proxy, String params) throws IOException {
//        HttpsURLConnection connection;
//        if (proxy == null) {
//            connection = (HttpsURLConnection) new URL(url).openConnection();
//        } else {
//            connection = (HttpsURLConnection) new URL(url).openConnection(proxy);
//        }
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setRequestProperty("Authorization", "Bearer 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");
//        connection.setDoOutput(true);
//        if (params != null && params.length() > 0) {
//            // 向请求正文中写入数据
//            try (OutputStream outputStream = connection.getOutputStream();) {
//                outputStream.write(params.getBytes());
//                outputStream.flush();
//            }
//        }
//        System.out.println(2222);
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String str;
//            while ((str = bufferedReader.readLine()) != null) {
//                stringBuilder.append(str);
//            }
//        }
//        System.out.println("stringBuilder:" + stringBuilder);
//        return stringBuilder.toString();
//    }
}
