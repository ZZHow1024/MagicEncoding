package com.zzhow.magicencoding.enums;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public enum TimeOperationType {
    FORWARD(0), BACKWARD(1);

    private final int value;

    private TimeOperationType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static TimeOperationType valueOf(int value) {
        return switch (value) {
            case 0 -> FORWARD;
            case 1 -> BACKWARD;
            default -> null;
        };
    }
}
