package com.xiaorboo.observer.thread;

/**
 * TODO...
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class ThreadDemo {

    public static void main(String[] args) {

        FirstListener firstListener = new FirstListener();
        SecondListener secondListener = new SecondListener();

        SourceRunnable runnable = new SourceRunnable(){
            @Override
            public void run() {
                notifyListeners(ThreadEvent.RUNNING);
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyListeners(ThreadEvent.FINISH);
            }
        };
        runnable.addListener(firstListener);
        runnable.addListener(secondListener);
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
