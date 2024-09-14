package com.zzhow.magicencoding.service.impl;

import com.zzhow.magicencoding.enums.TextEncodingType;
import com.zzhow.magicencoding.service.TextService;
import com.zzhow.magicencoding.utils.MyTextUtil;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public class TextServiceImpl implements TextService {
    private static final TextService textService = new TextServiceImpl();

    private TextServiceImpl() {

    }

    public static TextService getInstance() {
        return textService;
    }

    @Override
    public String encodeText(String original, String originalCharset, TextEncodingType type) {
        return MyTextUtil.encode(original, originalCharset, type);
    }

    @Override
    public String decodeText(String original, String originalCharset, TextEncodingType type) {
        return MyTextUtil.decode(original, originalCharset, type);
    }
}
