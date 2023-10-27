package org.example.view;

import org.example.utils.StringUtil;

import static org.example.utils.Utils.println;

public class HomePage {
    public void printMenu() {
        println(StringUtil.WELCOME_MESSAGE);
        println(StringUtil.HOME_MENU);
    }
}
