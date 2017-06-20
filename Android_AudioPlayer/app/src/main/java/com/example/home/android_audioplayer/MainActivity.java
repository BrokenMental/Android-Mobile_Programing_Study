package com.example.home.android_audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer objMP;
    private EditText audioSrcFile;
    private CheckBox chkLoopCTRL;
    private Button btnLoad, btnPlay, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioSrcFile = (EditText)findViewById(R.id.edtSrcFile);

        chkLoopCTRL = (CheckBox)findViewById(R.id.chkLoop);
        chkLoopCTRL.setOnClickListener(this);

        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnLoad) {
            if (!LoadAudioFile(audioSrcFile.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Audio File Load Fail !",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            audioSrcFile.setEnabled(false);
            btnPlay.setEnabled(true);
            btnStop.setEnabled(true);
            chkLoopCTRL.setEnabled(true);
            btnLoad.setEnabled(false);
            Toast.makeText(getApplicationContext(), "File : " +
                            audioSrcFile.getText().toString() + "Load Success !",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        } else if (v == btnPlay) {
            if (PlayPauseAudio() != true) {
                btnPlay.setText("Pause");
            } else {
                btnPlay.setText("Play");
            }
        } else if (v == btnStop) {
            objMP.stop();
            audioSrcFile.setEnabled(true);
            btnPlay.setText("Play");
            chkLoopCTRL.setChecked(false);
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
            chkLoopCTRL.setEnabled(false);
            btnLoad.setEnabled(true);
        } else if (v == chkLoopCTRL) {
            if (chkLoopCTRL.isChecked()) {
                objMP.setLooping(true);
                Toast.makeText(getApplicationContext(), "Loop Set Status",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                objMP.setLooping(false);
                Toast.makeText(getApplicationContext(), "Loop Reset Status",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
    private boolean PlayPauseAudio(){
        if(!objMP.isPlaying()){
            objMP.start();
            Toast.makeText(getApplicationContext(), "Play",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else{
            objMP.pause();
            Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
    private boolean LoadAudioFile(String path){
        objMP = new MediaPlayer();
        try{
            objMP.setDataSource(path);
            objMP.prepare();
            return true;
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void onDestroy(){
        super.onDestroy();
        if(objMP != null) objMP.release();
        objMP = null;
    }

}