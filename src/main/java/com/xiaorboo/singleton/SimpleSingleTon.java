package com.xiaorboo.singleton;

/**
 * 最简单的单例写法
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class SimpleSingleTon {

    private static final SimpleSingleTon instance = new SimpleSingleTon();

    //最简单的写法,但是不能懒加载,另外两种符合懒加载的方式
    public static SimpleSingleTon getInstance(){
        return instance;
    }
}
