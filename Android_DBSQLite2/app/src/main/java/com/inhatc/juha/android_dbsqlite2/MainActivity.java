package com.inhatc.juha.android_dbsqlite2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase myDB;
    SimpleAdapter myADT;
    ArrayList<String> aryMBRList;
    ArrayAdapter<String> adtMembers;
    TextView[] objTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = this.openOrCreateDatabase("PhoneBook", MODE_PRIVATE, null);
        myDB.execSQL("Drop table if exists members");

        myDB.execSQL("Create table members (" +
                " _id integer primary key autoincrement, " +
                "Name text not null, " + "Phone_No text not null);" );

        myDB.execSQL("Insert into members " +
                " (Name, Phone_No) values ('kdhong', '011-8701-2320');" );

        ContentValues insertValue = new ContentValues();
        insertValue.put("Name", "Juliet");
        insertValue.put("Phone_No", "010-1234-1234");
        myDB.insert("members", null, insertValue);

        insertValue.put("Name", "Romio");
        insertValue.put("Phone_No", "010-100-5678");
        myDB.insert("members", null, insertValue);

        Cursor allRCD = myDB.query("members", null,
                null, null, null, null, null, null);

        aryMBRList = new ArrayList<String>();
        if (allRCD != null){
            if(allRCD.moveToFirst()) {
                do{
                    aryMBRList.add(allRCD.getString(1));
                    aryMBRList.add(allRCD.getString(2));
                }while(allRCD.moveToNext());
            }
        }
        objTV = new TextView[8];
        objTV[0] = (TextView)findViewById(R.id.textView1);
        objTV[1] = (TextView)findViewById(R.id.textView2);
        objTV[2] = (TextView)findViewById(R.id.textView3);
        objTV[3] = (TextView)findViewById(R.id.textView4);
        objTV[4] = (TextView)findViewById(R.id.textView5);
        objTV[5] = (TextView)findViewById(R.id.textView6);
        objTV[6] = (TextView)findViewById(R.id.textView7);
        objTV[7] = (TextView)findViewById(R.id.textView8);

        for(int i=0; i <aryMBRList.size(); i++){
            objTV[i].setText(aryMBRList.get(i).toString());
        }
        if(myDB != null) myDB.close();
    }
}
