package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部 单例模式
 * 利用JVM的特性，支持延迟加载&高并发
 *
 */
public class IdGenerator4 {

    private AtomicLong atomicLong = new AtomicLong(0);

    private static IdGenerator4 instance = null;

    private IdGenerator4(){}

    /**
     *
     * 静态内部类，外部类被加载时不会创建实例对象
     * 只有调用getInstance时，才会被加载，才会创建instance
     * 唯一性和线程安全由JVM来保证
     *
     */
    private static class SingletonHolder {
        private static final IdGenerator4 instance = new IdGenerator4();
    }

    public static IdGenerator4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }

}
