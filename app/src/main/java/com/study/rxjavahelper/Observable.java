package com.study.rxjavahelper;

/**
 *
 */
public class Observable<T> {
    private OnSubscribe<T> onSubscribe;

    private Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    /**
     * 构建链式
     * @param onSubscribe 被观察者
     * @param <T> 具体的行为，使用泛型约束
     * @return
     */
    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<>(onSubscribe);
    }


    /**
     * 订阅方法发起点，通过调用成员变量的call方法，来调用被观察者中的call方法
     * 被观察者通知观察者的过程
     * @param subscribe 观察者
     */
    public void subscribe(Subscribe<? super T> subscribe){
        onSubscribe.call(subscribe);
    }




}
