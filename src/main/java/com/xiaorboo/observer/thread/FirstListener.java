package com.xiaorboo.observer.thread;

/**
 * TODO...
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class FirstListener implements LifeCycleListener {

    @Override
    public void onEvent(ThreadEvent event) {
        System.out.println("first receive:"+event);
    }

}
