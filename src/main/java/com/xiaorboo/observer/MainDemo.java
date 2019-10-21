package com.xiaorboo.observer;

/**
 * 测试主类
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class MainDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        FirstObserver firstObserver = new FirstObserver();
        SecondObserver secondObserver = new SecondObserver();

        subject.addObserver(firstObserver);
        subject.addObserver(secondObserver);

        subject.setState(1);
        System.out.println("===============");
        subject.setState(3);
    }
}
