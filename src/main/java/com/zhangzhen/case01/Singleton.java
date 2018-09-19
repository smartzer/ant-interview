package com.zhangzhen.case01;

/**
 * 懒汉模式单实例类实现，线程安全
 *
 * @author zhangzhen
 * @since 2018-09-18
 */
public class Singleton {

    // 禁止 JVM 指令重排序
    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // 这里的 new 操作也不是原子的，所以使用 volatile 修饰
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
