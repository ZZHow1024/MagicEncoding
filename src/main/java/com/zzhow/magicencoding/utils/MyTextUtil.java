package com.zzhow.magicencoding.utils;

import com.zzhow.magicencoding.enums.TextEncodingType;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public class MyTextUtil {
    public static String encode(String original, String originalCharset, TextEncodingType type) {
        switch (type) {
            case Unicode -> {
                // 将字符串中的每个字符转换为 Unicode 转义序列
                StringBuilder unicodeEncoded = new StringBuilder();
                for (char c : original.toCharArray()) {
                    unicodeEncoded.append(String.format("\\u%04x", (int) c));
                }

                return unicodeEncoded.toString();
            }
            case URL -> {
                // 使用 URLEncoder 类完成 URL 编码
                try {
                    return URLEncoder.encode(original, originalCharset);
                } catch (UnsupportedEncodingException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return null;
    }
}
