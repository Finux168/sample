package com.xiaorboo.observer.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听线程的生命周期
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public abstract class SourceRunnable implements Runnable {

    protected List<LifeCycleListener> listeners = new ArrayList<>();

    public void addListener(LifeCycleListener listener){
        this.listeners.add(listener);
    }

    protected void notifyListeners(ThreadEvent event){
        this.listeners.stream().forEach(listener -> {
            listener.onEvent(event);
        });
    }
}
