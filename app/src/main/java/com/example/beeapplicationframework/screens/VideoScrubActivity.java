package com.example.beeapplicationframework.screens;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

// TextureView code adapted from bemolmi
public class VideoScrubActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {

    String photoPath;
    Uri videoPath;
    TextureView videoviewer;
    private MediaPlayer mMediaPlayer;
    Boolean isPlaying;
    Button pausebutton;

    private static final String TAG = VideoScrubActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_scrub);

        photoPath = getIntent().getStringExtra("PHOTO_PATH");
        videoPath = Uri.parse(photoPath);

        videoviewer = (TextureView) findViewById(R.id.videoView);
        videoviewer.setSurfaceTextureListener(this);

        isPlaying = true;

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (VideoScrubActivity.this, PictureVideoSelectActivity.class);
                startActivity(intent);
            }
        });

        pausebutton = (Button) findViewById(R.id.pauseButton);
        pausebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isPlaying) {
                    mMediaPlayer.pause();
                    isPlaying = false;
                    pausebutton.setText("Play");
                } else {
                    mMediaPlayer.start();
                    isPlaying = true;
                    pausebutton.setText("Pause");
                }
            }
        });

        final Button capturebutton = (Button) findViewById(R.id.captureButton);
        capturebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bitmap snapshot = scaleDownBitmap(getBitmap(), 100, VideoScrubActivity.this);

                Intent intent = new Intent (VideoScrubActivity.this, LogBeeActivity_Menu.class);
                intent.putExtra("data", snapshot);
                intent.putExtra("PHOTO_PATH", photoPath);
                intent.putExtra("fromVideo", "True");
                startActivity(intent);
            }
        });
    }

    public Bitmap getBitmap(){
        return  videoviewer.getBitmap();
    }

    // Scaling function taken from GalDude33
    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {

        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        int h = (int) (newHeight * densityMultiplier);
        int w = (int) (h * photo.getWidth()/((double) photo.getHeight()));

        photo = Bitmap.createScaledBitmap(photo, w, h, true);

        return photo;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Surface surface = new Surface(surfaceTexture);

        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer
                    .setDataSource(this, videoPath);
            mMediaPlayer.setSurface(surface);
            mMediaPlayer.setLooping(true);

            // don't forget to call MediaPlayer.prepareAsync() method when you use constructor for
            // creating MediaPlayer
            mMediaPlayer.prepareAsync();
            // Play video when the media source is ready for playback.
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        } catch (IllegalArgumentException e) {
            Log.d(TAG, e.getMessage());
        } catch (SecurityException e) {
            Log.d(TAG, e.getMessage());
        } catch (IllegalStateException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            // Make sure we stop video and release resources when activity is destroyed.
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, PictureVideoSelectActivity.class);
        startActivity(intent);
    }
}
