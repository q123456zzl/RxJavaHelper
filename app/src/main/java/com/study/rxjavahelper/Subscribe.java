package com.study.rxjavahelper;

/**
 *观察者
 */

public abstract class Subscribe<T> {
    /**
     * @param t 代表具体的行为
     */
    public abstract void onNext(T t);
}
