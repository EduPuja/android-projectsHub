package com.example.exemplevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView video = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ibai;
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        video.requestFocus();
        video.start();
        video.setZOrderOnTop(true);

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                AudioManager mAudioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });


    }
}