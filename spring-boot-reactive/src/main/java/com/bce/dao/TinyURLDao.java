package com.bce.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TinyURLDao {


    String tinyURL(String longURL){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(longURL.getBytes());
            byte[] encodedBytes = Base64.getUrlEncoder().withoutPadding().encode(digest);
            return new String(encodedBytes).substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    String longURL(String tinyURL)
    {
        return  null;
    }
}
