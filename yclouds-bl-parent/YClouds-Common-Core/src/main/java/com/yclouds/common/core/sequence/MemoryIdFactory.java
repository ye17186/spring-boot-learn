package com.yclouds.common.core.sequence;

import com.yclouds.common.core.utils.IdGenUtils;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ye17186
 * @version 2019/3/22 17:12
 */
public class MemoryIdFactory implements IdFactory {

    /**
     * 当前seq
     */
    private static AtomicLong currentSeq = new AtomicLong(1);

    public static long nextId() {
        long seq = currentSeq.incrementAndGet();
        return seq % IdGenUtils.maxSeq;
    }
}
