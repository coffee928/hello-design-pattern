package com.zhsh.learn.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式单例模式
 * 实例在类加载时就已创建好，是线程完全的；
 * 不支持延迟加载
 *
 *
 */
public class IdGenerator1 {

    private AtomicLong atomicLong = new AtomicLong(0);

    private final static IdGenerator1 instance = new IdGenerator1();

    private IdGenerator1() {

    }

    public IdGenerator1 getInstance() {
        return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }
}
