package org.example.view;

import org.example.util.StringUtils;

public class LoginPage {
    public void printInvalidCredentials(){
        try {
            System.out.println("#---------------------#");
            System.out.println(StringUtils.INVALID_CREDENTIALS);
            System.out.println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
