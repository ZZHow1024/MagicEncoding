package com.zzhow.magicencoding.utils;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ZZHow
 * @date 2024/9/8
 */
public class MyCharsetUtil {
    public static UniversalDetector detector = new UniversalDetector(null);

    public static String getCharset(String path) {
        return getCharset(new File(path));
    }

    public static String getCharset(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[fis.available()];
            int readLength;
            while ((readLength = fis.read(buffer)) != -1 && !detector.isDone()) {
                detector.handleData(buffer, 0, readLength);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();

        if (encoding != null) {
            return encoding;
        } else {
            return "unknown";
        }
    }
}
