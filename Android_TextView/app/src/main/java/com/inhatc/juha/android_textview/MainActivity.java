package com.inhatc.juha.android_textview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        TextView objTV = new TextView(this);
        objTV.setText("Android Programming !");
        objTV.setGravity(0x11);
        objTV.setTextSize(32);
        objTV.setTextColor(Color.BLUE);
        setContentView(objTV);
    }
}
