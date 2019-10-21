package com.xiaorboo.singleton;

/**
 * 使用volatile实现的单例
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class VolatileSingleTon {

    private volatile static VolatileSingleTon instance;

    public VolatileSingleTon() {
    }

    public static VolatileSingleTon getInstance(){
        if (instance == null){
            synchronized (VolatileSingleTon.class){
                if (instance == null){
                    instance = new VolatileSingleTon();
                }
            }
        }
        return instance;
    }
}
