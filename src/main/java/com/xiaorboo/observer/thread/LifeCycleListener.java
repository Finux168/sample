package com.xiaorboo.observer.thread;

/**
 * 声明周期监听
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public interface LifeCycleListener {

    void onEvent(ThreadEvent event);
}
