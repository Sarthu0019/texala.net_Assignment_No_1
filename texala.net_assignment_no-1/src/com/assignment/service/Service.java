package com.assignment.service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Service {

    public static String getUrlResponseBody(String urlString){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            System.out.println(sb);
            writeToFile(sb.toString());
        }catch (Exception e){
            sb.append("Something went wrong");
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static void writeToFile(String str){
        try {
            FileOutputStream outputStream = new FileOutputStream("web-content.txt");
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        }catch (Exception e ){
            System.out.println("Failed to write to file");
        }
    }
}
