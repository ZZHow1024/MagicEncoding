package com.zzhow.magicencoding.service;

import com.zzhow.magicencoding.enums.TextEncodingType;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public interface TextService {

    /**
     * 字符文本编码
     *
     * @param original        原始字符串
     * @param originalCharset 原始字符集
     * @param type            编码类型
     * @return 编码后的字符串
     */
    String encodeText(String original, String originalCharset, TextEncodingType type);

    /**
     * 字符文本解码
     *
     * @param original        编码过的字符串
     * @param originalCharset 原始字符集
     * @param type            解码类型
     * @return 解码后的字符串
     */
    String decodeText(String original, String originalCharset, TextEncodingType type);

}
