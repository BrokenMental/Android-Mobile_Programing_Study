package com.example.home.android_video;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

// raw 폴더에 들어간 파일 실행할 때
/*public class MainActivity extends AppCompatActivity {

    VideoView objVideo;
    MediaController mediaCTRL;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        objVideo = (VideoView) findViewById(R.id.videoView);
        mediaCTRL = new MediaController(this);

        mediaCTRL.setAnchorView(objVideo);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/raw/wildlife");

        objVideo.setMediaController(mediaCTRL);
        objVideo.setVideoURI(videoUri);
        objVideo.requestFocus();
        objVideo.start();
    }
}*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 6.0버전 이상 따로 권한부여 할 때 사용
    /*private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    public static void verifyStoragePermissions(Activity activity){
        int permission = ActivityCompat.checkSelfPermission(
                activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
        }

    }*/

    VideoView objVideo;
    MediaController mediaCTRL;
    private EditText videoSrcFile;
    private Button btnLoad, btnPlay, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 6.0버전 이상 따로 권한부여 할 때 사용
        /*MainActivity.verifyStoragePermissions(MainActivity.this);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objVideo=(VideoView)findViewById(R.id.videoView);
        mediaCTRL = new MediaController(this);
        mediaCTRL.setAnchorView(objVideo);

        videoSrcFile=(EditText)findViewById(R.id.edtSrcFile);

        btnLoad=(Button)findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        btnPlay=(Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        btnStop=(Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(v==btnLoad){
            if(!LoadVideoFile(videoSrcFile.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Video File Load Fail !",
                                Toast.LENGTH_LONG)
                        .show();
                return;
            }

            videoSrcFile.setEnabled(false);
            btnPlay.setEnabled(true);
            btnStop.setEnabled(true);
            btnLoad.setEnabled(false);
            Toast.makeText(getApplicationContext(), "File : "+
                            videoSrcFile.getText().toString() +" Load Success !",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }else if(v==btnPlay) {
            if(PlayPauseVideo() != true ){
                btnPlay.setText("Pause");
            }else {
                btnPlay.setText("Play");
            }
        }else if(v==btnStop) {
            objVideo.stopPlayback();
            videoSrcFile.setEnabled(true);
            btnPlay.setText("Play");
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
            btnLoad.setEnabled(true);
        }
    }

    private boolean PlayPauseVideo() {
        if(!objVideo.isPlaying()) {
            objVideo.start();
            Toast.makeText(getApplicationContext(),"Play",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else {
            objVideo.pause();
            Toast.makeText(getApplicationContext(),"Pause", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean LoadVideoFile(String path){
        objVideo.setMediaController(mediaCTRL);
        try {
            objVideo.setVideoPath(path);
            objVideo.requestFocus();
            return true;
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}