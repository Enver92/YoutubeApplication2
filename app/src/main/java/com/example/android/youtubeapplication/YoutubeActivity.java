package com.example.android.youtubeapplication;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private final String GOOGLE_API_KEY = "AIzaSyBHNGLZj-gKw2ujpZwgLLRmuEOS31upX0E";
    private final String YOUTUBE_VIDEO_ID = "Sh_EJ7SnSLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            Toast.makeText(this, "Initialized Youtube Player Successfully", Toast.LENGTH_LONG).show();
            youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
            youTubePlayer.setPlaybackEventListener(playbackEventListener);

            if(!wasRestored) {
                youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            }
        }


        private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(YoutubeActivity.this, "Good, video is playing ok!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(YoutubeActivity.this, "Video is paused!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

        private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {
                Toast.makeText(YoutubeActivity.this, "Click ad now, make the video creator rich!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(YoutubeActivity.this, "The video has started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            Toast.makeText(this, "Failed to initialize Youtube player", Toast.LENGTH_LONG).show();
        }

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


}
