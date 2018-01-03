package com.study.rxjavahelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getClass().getSimpleName();
    private ImageView mainIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainIv = findViewById(R.id.main_iv);
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
                Log.i(TAG, s);
            }
        });

    }

    public void transform(View v) {
        Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscribe<? super String> subscribe) {
                Log.i(TAG, "1");
                subscribe.onNext("图片链接");
            }
        }).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.i(TAG, "2" + s);
                return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            }
        }).subscribe(new Subscribe<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                mainIv.setImageBitmap(bitmap);
                Log.i(TAG,"3");
            }
        });
    }
}
