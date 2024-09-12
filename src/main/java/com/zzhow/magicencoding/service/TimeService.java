package com.zzhow.magicencoding.service;

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

}
