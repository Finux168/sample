package com.xiaorboo.observer;

/**
 * 监听实现类
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class FirstObserver extends Observer {

    @Override
    void update(int state) {
        System.out.println("first---"+state);
    }

}
