package com.study.rxjavahelper;

/**
 * 操作类
 */

public interface Operator<T,R> extends Func1<Subscribe<? super T>,Subscribe<? super R>> {


}
