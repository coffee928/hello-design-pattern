package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举 单例模式
 *
 */
public enum IdGenerator5 {

    INSTANCE;

    private AtomicLong atomicLong = new AtomicLong(0);

    public long getId() {
        return atomicLong.incrementAndGet();
    }

}
