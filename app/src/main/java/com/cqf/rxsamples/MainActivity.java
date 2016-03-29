package com.cqf.rxsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;
    @Bind(R.id.btn4)
    Button btn4;
    @Bind(R.id.btn5)
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onClick(View view) {
        Intent i = new Intent();
        switch (view.getId()) {
            case R.id.btn1:
                i.setClass(this,RxSample1.class);
                break;
            case R.id.btn2:
                i.setClass(this,RxSample2.class);
                break;
            case R.id.btn3:
                i.setClass(this,RxSample3.class);
                break;
            case R.id.btn4:
                i.setClass(this,RxSample4.class);
                break;
            case R.id.btn5:
                i.setClass(this,RxSample5.class);
                break;
        }
        startActivity(i);
    }
}
