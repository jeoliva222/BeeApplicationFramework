package com.example.beeapplicationframework.screens;

import android.Manifest;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.beeapplicationframework.objects.QuestionBranchList;
import com.example.beeapplicationframework.objects.QuestionFlagList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class InspectLogActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {

    String bee, photoPath, head, thorax, abdomen, f_color, f_shape;
    Boolean fromVideo;

    ImageView beeimg;
    TextureView beevid;
    MediaPlayer mMediaPlayer;
    String videoPath;

    private static final String TAG = InspectLogActivity.class.getName();

    int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_log);

        this.bee = getIntent().getStringExtra("BEE");
        this.photoPath = getIntent().getStringExtra("PHOTO_PATH");
        this.head = getIntent().getStringExtra("HEAD");
        this.thorax = getIntent().getStringExtra("THORAX");
        this.abdomen = getIntent().getStringExtra("ABDOMEN");
        this.f_color = getIntent().getStringExtra("F_COLOR");
        this.f_shape = getIntent().getStringExtra("F_SHAPE");

        this.fromVideo = Boolean.parseBoolean(getIntent().getStringExtra("fromVideo"));


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 3.0f);
        LinearLayout ll = (LinearLayout) findViewById(R.id.pictureLayout);
        beevid = (TextureView) findViewById(R.id.videoView);

        if(fromVideo) {
            videoPath = getRealPathFromURI(Uri.parse(photoPath));
            beevid.setSurfaceTextureListener(this);

        } else {
            beevid.setVisibility(View.GONE);

            beeimg = new ImageView(this);
            ll.addView(beeimg, lp);

            setPic();
        }

        Resources res = getResources();

        ImageView headimg = (ImageView) findViewById(R.id.headView); // Display the bee's head coloration on the screen
        int headID = res.getIdentifier(head, "mipmap", getPackageName());
        headimg.setImageResource(headID);

        ImageView thoraximg = (ImageView) findViewById(R.id.thoraxView); // Display the bee's thorax coloration on the screen
        int thoraxID = res.getIdentifier(thorax, "mipmap", getPackageName());
        thoraximg.setImageResource(thoraxID);

        ImageView abdomenimg = (ImageView) findViewById(R.id.abdomenView); // Display the bee's abdomen coloration on the screen
        int abdomenID = res.getIdentifier(abdomen, "mipmap", getPackageName());
        abdomenimg.setImageResource(abdomenID);

        TextView flowerDetailText = (TextView) findViewById(R.id.flowerDetailText);
        flowerDetailText.setText(f_color + " Color and " + f_shape + " Shape");

        TextView speciesText = (TextView) findViewById(R.id.speciesText);
        speciesText.setText("Bombus " + bee);

        final Button backbutton = (Button) findViewById(R.id.backButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (InspectLogActivity.this, MyLogsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Surface surface = new Surface(surfaceTexture);

        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer
                    .setDataSource(this, Uri.parse(videoPath));
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

    private String getRealPathFromURI(Uri contentUri) {
        if (ContextCompat.checkSelfPermission(InspectLogActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(InspectLogActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    private void setPic() {
        // Get the dimensions of the View
        int targetW = 600;
        int targetH = 600;

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(photoPath, bmOptions);
        beeimg.setImageBitmap(bitmap);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (InspectLogActivity.this, MyLogsActivity.class);
        startActivity(intent);
    }
}
