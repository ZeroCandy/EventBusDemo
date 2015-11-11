package com.candy.eventbusdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.candy.eventbusdemo.R;
import com.candy.eventbusdemo.event.FirstEvent;
import com.candy.eventbusdemo.event.SecondEvent;
import com.candy.eventbusdemo.event.ThirdEvent;

import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {
    private static final String TAG="MainActivity";

    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        btn= (Button) findViewById(R.id.btn_try);
        tv= (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onEventMainThread(FirstEvent event){
        String msg="onEventMainThread方法收到消息:"+event.getMsg();
        Log.i(TAG,msg);
        tv.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void onEventMainThread(SecondEvent event){
        String msg="onEventMainThread方法收到消息:"+event.getMsg();
        Log.i(TAG,msg);
        tv.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void onEvent(ThirdEvent event){
        String msg="onEvent方法收到消息:"+event.getMsg();
        Log.i(TAG,msg);
        tv.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解注EventBus
        EventBus.getDefault().unregister(this);
    }
}
