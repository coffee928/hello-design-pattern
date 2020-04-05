package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检查 单例模式
 * 支持延迟加载且支持高并发
 */
public class IdGenerator3 {

    private AtomicLong atomicLong = new AtomicLong(0);

    /**
     * 加上 volatile 防止指令重排序
     */
    private volatile static IdGenerator3 instance = null;

    private IdGenerator3(){}

    public static IdGenerator3 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator3.class) {
                instance = new IdGenerator3();
            }
        }
        return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }

}
