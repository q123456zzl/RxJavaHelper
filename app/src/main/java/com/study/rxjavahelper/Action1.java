package com.study.rxjavahelper;

/**
 * 行为，命令的方法
 */

public interface Action1<T> {
    //执行的行为
    void call(T t);
}
