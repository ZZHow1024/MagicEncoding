package com.zzhow.magicencoding.service;

import com.zzhow.magicencoding.enums.TimeOperationType;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author ZZHow
 * @date 2024/9/12
 */
public interface TimeService {

    /**
     * 时间戳转时间
     *
     * @param timestamp 时间戳
     * @return 时间
     */
    public String timestampToTime(long timestamp, TimeUnit unit);

    /**
     * 时间转时间戳
     *
     * @param time 时间
     * @return 时间戳
     */
    public String timeToTimestamp(LocalDateTime time, TimeUnit unit);

    /**
     * 时间操作
     *
     * @param time   待操作的时间
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   时
     * @param minute 分
     * @param second 秒
     * @return 操作后的时间
     */
    public String timeOperate(TimeOperationType type, String time, String year, String month, String day, String hour, String minute, String second);

}
