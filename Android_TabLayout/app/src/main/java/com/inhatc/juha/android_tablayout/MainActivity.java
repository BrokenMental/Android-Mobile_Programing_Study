package com.inhatc.juha.android_tablayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost myTabHost = null;
    TabHost.TabSpec myTabSpec;
    Drawable imgIcon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTabHost = (TabHost)findViewById(R.id.tabhost);
        myTabHost.setup();

        imgIcon = getResources().getDrawable(R.drawable.artists, getTheme());
        myTabSpec = myTabHost.newTabSpec("Artists")
                .setIndicator("Artists",imgIcon)
                .setContent(R.id.tab1);
        myTabHost.addTab(myTabSpec);

        imgIcon = getResources().getDrawable(R.drawable.album, getTheme());
        myTabSpec = myTabHost.newTabSpec("Albums")
                .setIndicator("Albums",imgIcon)
                .setContent(R.id.tab2);
        myTabHost.addTab(myTabSpec);

        imgIcon = getResources().getDrawable(R.drawable.song, getTheme());
        myTabSpec = myTabHost.newTabSpec("Songs")
                .setIndicator("Songs",imgIcon)
                .setContent(R.id.tab3);
        myTabHost.addTab(myTabSpec);

        myTabHost.setCurrentTab(0);

        myTabHost.getTabWidget().getChildTabViewAt(0).setBackgroundColor(Color.parseColor("#FF0000"));
        myTabHost.getTabWidget().getChildTabViewAt(1).setBackgroundColor(Color.parseColor("#00FF00"));
        myTabHost.getTabWidget().getChildTabViewAt(2).setBackgroundColor(Color.parseColor("#0000FF"));

        for(int idx=0; idx < myTabHost.getTabWidget().getChildCount();++idx)
            myTabHost.getTabWidget().getChildAt(idx).getLayoutParams().height = 150;
    }
}
