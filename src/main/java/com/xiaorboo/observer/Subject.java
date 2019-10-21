package com.xiaorboo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void setState(int state){
        this.state = state;
        notifyAllObserver();
    }

    private void notifyAllObserver(){
        observers.stream().forEach(observer -> {
            observer.update(this.state);
        });
    }
}
