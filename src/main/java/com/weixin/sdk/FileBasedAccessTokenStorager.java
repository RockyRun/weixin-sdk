package com.weixin.sdk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBasedAccessTokenStorager implements AccessTokenStorager{

    private String fileName = "access_token.txt";

    public void saveAccessToken(AppSpecific appSpecific, AccessToken accessToken) {
        writeTokenIntoFile(accessToken.getToken(), accessToken.getExpiresAt());
    }

    public AccessToken loadAccessToken(AppSpecific appSpecific) {
        return readTokenIntoFile();
    }

    public void writeTokenIntoFile(String token, long expireAt) {
        try {

            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), false);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(token);
            bufferWritter.write("\r\n");
            bufferWritter.write(String.valueOf(expireAt));
            bufferWritter.close();

//            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccessToken readTokenIntoFile() {
        try {

            File file = new File(fileName);

            if (!file.exists()) {
                return null;
            }

            FileReader fileReader = new FileReader(file.getName());
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String accessToken = bufferReader.readLine();
            String expireAtStr = bufferReader.readLine();
            bufferReader.close();
            return new AccessToken(accessToken, Long.valueOf(expireAtStr));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
}
