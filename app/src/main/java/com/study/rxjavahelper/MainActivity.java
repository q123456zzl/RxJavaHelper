package com.study.rxjavahelper;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        //简单的链式调度
        Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscribe<? super String> subscribe) {
                Log.i(TAG, "1");
                SystemClock.sleep(3000);
                subscribe.onNext("图片链接");
                Log.i(TAG, "3");
            }
        }).subscribe(new Subscribe<String>() {
            @Override
            public void onNext(String s) {
                Log.i(TAG, "2");
            }
        });
    }
}
