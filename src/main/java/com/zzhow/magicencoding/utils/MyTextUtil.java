package com.zzhow.magicencoding.utils;

import com.zzhow.magicencoding.enums.TextEncodingType;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String decode(String original, String originalCharset, TextEncodingType type) {
        switch (type) {
            case Unicode -> {
                // 通过正则表达式，将字符串中的每个 Unicode 转义序列转为字符序列
                Pattern pattern = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
                Matcher matcher = pattern.matcher(original);

                StringBuilder stringBuilder = new StringBuilder();
                while (matcher.find()) {
                    String s = String.valueOf((char) Integer.parseInt(matcher.group(1), 16));
                    matcher.appendReplacement(stringBuilder, s);
                }
                matcher.appendTail(stringBuilder);

                return stringBuilder.toString();
            }
            case URL -> {
                // 使用 URLEncoder 类完成 URL 解码
                try {
                    return URLDecoder.decode(original, originalCharset);
                } catch (UnsupportedEncodingException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return null;
    }
}
