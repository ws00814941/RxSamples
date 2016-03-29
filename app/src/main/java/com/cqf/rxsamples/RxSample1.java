package com.cqf.rxsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;

public class RxSample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i("other",s);
            }
        };
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
        Observable observable2 = Observable.just("Hello2", "Hi2", "Aloha2");
        String[] words = {"Hello3", "Hi3", "Aloha3"};
        Observable observable3 = Observable.from(words);
        //重复注册时无效的 因为subscriber包装成了safesubscriber oncomplete方法里面调用了unsubscribe
        //observable.subscribe(subscriber);
    }
}
