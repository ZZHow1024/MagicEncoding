package com.zzhow.magicencoding.service.impl;

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
}
