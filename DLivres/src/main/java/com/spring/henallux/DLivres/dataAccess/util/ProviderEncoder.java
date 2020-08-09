package com.spring.henallux.DLivres.dataAccess.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class ProviderEncoder {

    private static MessageDigest messageDigest;

    public ProviderEncoder ()
    {}



    public String cryptWithMD5(String password){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            messageDigest.reset();
            byte[] digested = messageDigest.digest(passBytes);
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                stringBuffer.append(Integer.toHexString(0xff & digested[i]));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException ex) {

        }
        return null;


    }
}
