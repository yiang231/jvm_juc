package com.atguigu.heap;

/**
 * 对象内存布局
 */
public class ObjectDemo {
    public static void main(String[] args) {
        // new 出来的对象一开始占用多大内存空间
        Object o = new Object();
        //对象的hashCode既然可以打印出来,那么他存在什么地方
        System.out.println(o.hashCode());
        //o此时为一把锁,他是如何知道锁了几次,是否被加锁,是在哪些地方标注和说明的
        synchronized (o){}
        //手动收集垃圾,有些会被回收,有的不会被回收,此时有一个分代年龄为15
        System.gc();
    }
}
