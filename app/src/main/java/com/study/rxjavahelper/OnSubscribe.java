package com.study.rxjavahelper;

/**
 * 被观察者
 * 在调用层实例化
 *
 * T 代表具体的行为
 * Subscribe 代表
 * 泛型PECS法则，super用于参数类型的限定，使用extends来确定范围值的范围
 */
public interface OnSubscribe<T> extends Action1<Subscribe<? super T>> {

}
