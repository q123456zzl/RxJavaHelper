package com.study.rxjavahelper;

/**
 * 操作符转化的类
 * T传入泛型
 * R返回的泛型
 */

public class OnSubScribeLift<T,R> implements OnSubscribe<R> {
    //持有的引用
    OnSubscribe<T> parent;

    //操作对象,用于返回T
    Operator<? extends R,? super T> operator;

    public OnSubScribeLift(OnSubscribe<T> parent, Operator<? extends R, ? super T> operator) {
        this.parent = parent;
        this.operator = operator;
    }

    @Override
    public void call(Subscribe<? super R> subscribe) {
        Subscribe<? super T> st = operator.call(subscribe);
        parent.call(st);
    }
}
