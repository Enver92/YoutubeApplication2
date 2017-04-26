package com.example.android.youtubeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    private final String GOOGLE_API_KEY = "AIzaSyBHNGLZj-gKw2ujpZwgLLRmuEOS31upX0E";
    private final String YOUTUBE_VIDEO_ID = "Sh_EJ7SnSLY";
    private final String YOUTUBE_PLAYLIST = "PLuC1XWzG9bjHWLS-HxTtmaanwAd7KrJKZ";

    private Button btnPlayVideo;
    private Button btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);

        btnPlaylist = (Button) findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);

        btnPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        // One onClickListener for both buttons
        switch(v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if(intent!=null) {
            startActivity(intent);
        }
    }
}
