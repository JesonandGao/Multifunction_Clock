package com.example.angluswang.clock;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Jeson on 2016/5/24.
 * 计时器类
 */

public class TimerView extends LinearLayout {

    public TimerView(Context context) {
        super(context);
    }

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        etHour = (EditText) findViewById(R.id.etHour);
        etMin = (EditText) findViewById(R.id.etMin);
        etSec = (EditText) findViewById(R.id.etSec);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnResume = (Button) findViewById(R.id.btnResume);
        btnReset = (Button) findViewById(R.id.btnReset);

        etHour.setText("00");
        etHour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int value = Integer.parseInt(s.toString());

                if (value >= 59) {
                    etHour.setText("59");
                }else if (value <= 0){
                    etHour.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etMin.setText("00");
        etSec.setText("00");

        btnStart.setVisibility(VISIBLE);
        btnStart.setEnabled(false);
        btnPause.setVisibility(GONE);
        btnResume.setVisibility(GONE);
        btnReset.setVisibility(GONE);
    }

    private EditText etHour, etMin, etSec;
    private Button btnStart, btnPause, btnResume, btnReset;

}
