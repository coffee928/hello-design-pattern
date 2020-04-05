package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程内唯一
 */
public class IdGenerator6 {

    private AtomicLong atomicLong = new AtomicLong(0);

    private static ConcurrentHashMap<Long, IdGenerator6> instanceMap = new ConcurrentHashMap<>();

    public static IdGenerator6 getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instanceMap.putIfAbsent(currentThreadId, new IdGenerator6());
        return instanceMap.get(currentThreadId);
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }

}
