package com.xiaorboo.singleton;

/**
 * 内部holder单例写法(推荐)
 *
 * @Author: fgd
 * @Date: 2019-10-21
 */
public class InnerHolderSingleTon {

    private static class SingleHolder{
        private static final InnerHolderSingleTon instance = new InnerHolderSingleTon();
    }

    public static InnerHolderSingleTon getInstance(){
        return SingleHolder.instance;
    }
}
