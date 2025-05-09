package com.example.formuskan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.chibde.visualizer.CircleBarVisualizer;

public class VoiceMessageActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_AUDIO = 1;
    private MediaPlayer mediaPlayer;
    private CircleBarVisualizer circleVisualizer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voice_message);

        playButton = findViewById(R.id.playButton);
        circleVisualizer = findViewById(R.id.visualizer);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    PERMISSION_REQUEST_AUDIO);
        } else {
            setupMediaPlayer();
        }

        playButton.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setText("🎧 Tap to hear your favorite voice 💞");
                } else {
                    mediaPlayer.start();
                    playButton.setText("⏸ Pause");
                }
            }
        });
    }

    private void setupMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.pagal);

        if (mediaPlayer != null) {
            int audioSessionId = mediaPlayer.getAudioSessionId();
            if (audioSessionId != -1) {
                circleVisualizer.setPlayer(audioSessionId);
            } else {
                Toast.makeText(this, "Failed to get audio session ID", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "MediaPlayer failed to initialize", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (circleVisualizer != null) {
            circleVisualizer.release();
        }
        super.onDestroy();
    }

    // Handle permission result
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupMediaPlayer();
            } else {
                Toast.makeText(this, "Permission needed for visualizer", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
