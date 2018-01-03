package com.study.rxjavahelper;

/**
 * 事件转化类
 */
public interface Func1<T, R> {
    R call(T t);
}
