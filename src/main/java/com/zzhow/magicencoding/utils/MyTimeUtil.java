package com.zzhow.magicencoding.utils;

import com.zzhow.magicencoding.enums.TimeOperationType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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

    public static LocalDateTime timeOperate(TimeOperationType type, LocalDateTime localDateTime, long year, long month, long day, long hour, long minute, long second) {
        if (type == TimeOperationType.FORWARD) {
            localDateTime = localDateTime.plusYears(year);
            localDateTime = localDateTime.plusMonths(month);
            localDateTime = localDateTime.plusDays(day);
            localDateTime = localDateTime.plusHours(hour);
            localDateTime = localDateTime.plusMinutes(minute);
            localDateTime = localDateTime.plusSeconds(second);
        } else {
            localDateTime = localDateTime.minusYears(year);
            localDateTime = localDateTime.minusMonths(month);
            localDateTime = localDateTime.minusDays(day);
            localDateTime = localDateTime.minusHours(hour);
            localDateTime = localDateTime.minusMinutes(minute);
            localDateTime = localDateTime.minusSeconds(second);
        }

        return localDateTime;
    }

}
