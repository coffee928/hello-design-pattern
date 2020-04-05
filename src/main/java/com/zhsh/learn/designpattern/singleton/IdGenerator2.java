package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式 单例模式
 * 支持延迟加载，获取对象的方法上加了方法锁，并不高效
 */
public class IdGenerator2 {

    private AtomicLong atomicLong = new AtomicLong(0);

    private static IdGenerator2 instance = null;

    private IdGenerator2(){}

    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }

}
