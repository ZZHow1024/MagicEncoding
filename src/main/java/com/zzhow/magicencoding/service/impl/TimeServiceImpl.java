package com.zzhow.magicencoding.service.impl;

import com.zzhow.magicencoding.enums.TimeOperationType;
import com.zzhow.magicencoding.service.TimeService;
import com.zzhow.magicencoding.utils.MyTimeUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public class TimeServiceImpl implements TimeService {
    private static final TimeService timeService = new TimeServiceImpl();

    private TimeServiceImpl() {

    }

    public static TimeService getInstance() {
        return timeService;
    }

    @Override
    public String timestampToTime(long timestamp, TimeUnit unit) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (unit == TimeUnit.MILLISECONDS)
            timestamp /= 1000;

        return dateTimeFormatter.format(MyTimeUtil.timestampToLocalDateTime(timestamp));
    }

    @Override
    public String timeToTimestamp(LocalDateTime time, TimeUnit unit) {
        long timestamp = MyTimeUtil.localDateTimeToTimestamp(time);

        return String.valueOf(unit == TimeUnit.SECONDS ? timestamp / 1000 : timestamp);
    }

    @Override
    public String timeOperate(TimeOperationType type, String time, String year, String month, String day, String hour, String minute, String second) {
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        long yearLong = 0;
        long monthLong = 0;
        long dayLong = 0;
        long hourLong = 0;
        long minuteLong = 0;
        long secondLong = 0;

        if (year != null && !year.isEmpty())
            try {
                yearLong = Long.parseLong(year);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        if (month != null && !month.isEmpty())
            try {
                monthLong = Long.parseLong(month);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        if (day != null && !day.isEmpty())
            try {
                dayLong = Long.parseLong(day);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        if (hour != null && !hour.isEmpty())
            try {
                hourLong = Long.parseLong(hour);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        if (minute != null && !minute.isEmpty())
            try {
                minuteLong = Long.parseLong(minute);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        if (second != null && !second.isEmpty())
            try {
                secondLong = Long.parseLong(second);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        LocalDateTime res = MyTimeUtil.timeOperate(type, localDateTime, yearLong, monthLong, dayLong, hourLong, minuteLong, secondLong);

        return res.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
