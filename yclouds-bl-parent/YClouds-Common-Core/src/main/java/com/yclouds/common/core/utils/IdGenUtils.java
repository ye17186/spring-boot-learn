package com.yclouds.common.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ID生成器
 *
 * @author yemeng-lhq
 * @version 2019/3/22 15:16
 */
public class IdGenUtils {

    private IdGenUtils() {
    }

    private static final int YEAR_LEN = 2;
    private static final int DAY_LEN = 3;
    private static final String TIME_FORMAT = "HHmmss";
    private static final int SEQ_LEN = 5;
    private static final int maxSeq = 99999;

    private static AtomicLong currentSeq = new AtomicLong(1);

    /**
     * 基于内存生成唯一ID
     * <br>
     * 1-2位：年份；3-5：年中第N天；6-11：时分秒：12-16：序列号
     * 支持每秒钟生成最多生成99999个ID
     *
     * @return 全局唯一ID
     */
    public static long nextIdByMem() {

        long seq = currentSeq.getAndIncrement();
        if(seq > maxSeq) {
            currentSeq.set(1);
        }
        LocalDateTime now = LocalDateTime.now();

        String year = StringUtils.right(String.valueOf(now.getYear()), YEAR_LEN);
        String day = StringUtils.leftPadZero(now.getDayOfYear(), DAY_LEN);
        String time = now.format(DateTimeFormatter.ofPattern(TIME_FORMAT));
        String seqStr = StringUtils.leftPadZero((int) seq, SEQ_LEN);

        return Long.valueOf(year + day + time + seqStr);
    }

}
