package com.study.rxjavahelper;


public class OperatorMap<T, R> implements Operator<R, T> {

    Func1<? super T, ? extends R> transform;

    public OperatorMap(Func1<? super T, ? extends R> transform) {
        this.transform = transform;
    }

    @Override
    public Subscribe<? super T> call(Subscribe<? super R> subscribe) {
        return new MapSubscriber<>(subscribe, transform);
    }

    private class MapSubscriber<T, R> extends Subscribe<T> {
        private Subscribe<? super R> actual;
        private Func1<? super T, ? extends R> transform;

        public MapSubscriber(Subscribe<? super R> actual, Func1<? super T, ? extends R> transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {
            /**
             * 最后一步的事件转换,
             * 被观察者订阅最终的观察者
             */
            R r = transform.call(t);
            actual.onNext(r);
        }
    }
}
