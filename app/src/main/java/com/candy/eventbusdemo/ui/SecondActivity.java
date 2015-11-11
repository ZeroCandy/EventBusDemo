package com.candy.eventbusdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.candy.eventbusdemo.R;
import com.candy.eventbusdemo.event.FirstEvent;
import com.candy.eventbusdemo.event.SecondEvent;
import com.candy.eventbusdemo.event.ThirdEvent;

import de.greenrobot.event.EventBus;

public class SecondActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.btn_first_event).setOnClickListener(this);
        findViewById(R.id.btn_second_event).setOnClickListener(this);
        findViewById(R.id.btn_third_event).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_first_event:
                //发送消息
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
                break;
            case R.id.btn_second_event:
                EventBus.getDefault().post(new SecondEvent("SecondEvent btn clicked"));
                break;
            case R.id.btn_third_event:
                EventBus.getDefault().post(new ThirdEvent("ThirdEvent btn clicked"));
                break;
        }
    }
}
