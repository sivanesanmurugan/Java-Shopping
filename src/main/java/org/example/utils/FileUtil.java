package org.example.utils;

import java.io.File;

public class FileUtil {

    private static File credentailsFile;

    public static File getCredentialsFile() {
        if (credentailsFile == null)
            credentailsFile = new File("src/main/java/org/example/assests/credentials.csv");
        return credentailsFile;
    }
}
