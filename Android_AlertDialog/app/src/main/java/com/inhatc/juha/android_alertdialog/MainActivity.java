package com.inhatc.juha.android_alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ToggleButton objTGButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTGButton = (ToggleButton)findViewById(R.id.tgbtnSwitch);
        objTGButton.setOnClickListener(this);
    }

    public void onClick(View v){
        showDialog(0);
    }

    /**
     * @param id
     * @deprecated Old no-arguments version of {@link #onCreateDialog(int, Bundle)}.
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        super.onCreateDialog(id);

        AlertDialog dlgAlert;
        final String items[] = {"통화 계속", "통화 종료"};

        dlgAlert = new AlertDialog.Builder(this)
                .setIcon(R.drawable.question)
                .setTitle("알림!")
                .setMessage("통화시간 3분 초과!")

                // setVeiw 구현 시 실행
                .setView(createCustomView())

                /* setView(null)일 경우 실행
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int index) {
                        String strData = null;
                        if (index == 0) strData = "통화중...";
                        else strData = "통화를 종료합니다.";
                        Toast.makeText(MainActivity.this, strData, Toast.LENGTH_SHORT).show();
                    }
                })
                .setView(null)
                */

                .setPositiveButton("확인(OK)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        objTGButton.setChecked(false);
                        dialog.dismiss();
                    }
                })
                .create();

        /* 리스트 없이 확인만 누르면 될 경우
        dlgAlert = new AlertDialog.Builder(this)
                .setIcon(R.drawable.question)
                .setTitle("알림 !")
                .setMessage("통화시간 3분 초과!")
                .setView(null)
                .setPositiveButton("확인(OK)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
                */
        return dlgAlert;
    }

    /**
     * @param id
     * @param dialog
     * @deprecated Old no-arguments version of
     * {@link #onPrepareDialog(int, Dialog, Bundle)}.
     */
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }

// setView() 구현 메서드
    private LinearLayout createCustomView() {
        LinearLayout objLayoutView;
        ListView lstViewCalling;
        ArrayList<String> lstItems;
        ArrayAdapter<String> aryADTItems;

        objLayoutView = new LinearLayout(this);
        lstViewCalling = new ListView(this);
        lstItems = new ArrayList<String>();
        lstItems.add("통화 계속");
        lstItems.add("통화 종료");

        aryADTItems = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_single_choice, lstItems);

        lstViewCalling.setAdapter(aryADTItems);
        lstViewCalling.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstViewCalling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                String strData = null;
                if (index == 0) strData = "통화중...";
                else strData = "통화를 종료합니다.";
                Toast.makeText(MainActivity.this, strData, Toast.LENGTH_SHORT).show();
            }
        });
        objLayoutView.setOrientation(LinearLayout.VERTICAL);
        objLayoutView.addView(lstViewCalling);
        return objLayoutView;
    }
}
