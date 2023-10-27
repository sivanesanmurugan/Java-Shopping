package org.example.utils;
import java.util.InputMismatchException;

import static org.example.utils.AppScanner.getScanner;
import static org.example.utils.Utils.print;
public class AppInput {
    public static String enterString(String msg) {
        print(msg);
        return getScanner().nextLine();
    }

    public static int enterInt(String msg) throws AppException {
        print(msg);
        int input;
        try {
            input = Integer.parseInt(getScanner().nextLine());
        } catch (Exception ex) {
            throw new AppException(StringUtil.INVALID_CHOICE);
        }
        return input;
    }
}
