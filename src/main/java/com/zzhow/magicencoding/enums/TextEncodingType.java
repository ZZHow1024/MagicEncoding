package com.zzhow.magicencoding.enums;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public enum TextEncodingType {
    Unicode(0), URL(1);

    private final int value;

    private TextEncodingType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static TextEncodingType valueOf(int value) {
        switch (value) {
            case 0 -> {
                return Unicode;
            }
            case 1 -> {
                return URL;
            }
        }

        return null;
    }
}
