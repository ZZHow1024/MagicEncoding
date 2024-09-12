package com.zzhow.magicencoding.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public class MyTimeUtil {

    public static LocalDateTime timestampToLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);

        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
