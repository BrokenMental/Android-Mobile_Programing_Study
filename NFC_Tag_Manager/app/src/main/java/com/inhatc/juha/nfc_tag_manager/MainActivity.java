package com.inhatc.juha.nfc_tag_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNFCReader;
    private Button btnNFCWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNFCReader = (Button)findViewById(R.id.btnReader);
        btnNFCReader.setOnClickListener(this);

        btnNFCWriter = (Button)findViewById(R.id.btnWriter);
        btnNFCWriter.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == btnNFCReader){
            Intent NFCReader = new Intent(MainActivity.this, NFC_Reader_Source.class);
            startActivity(NFCReader);
        }else if (v == btnNFCWriter){
            Intent NFCWriter = new Intent(MainActivity.this, NFC_Writer_Source.class);
            startActivity(NFCWriter);
        }
    }
}
