package com.example.travelmalaysia.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelmalaysia.Kedah.GunungJeraiResortActivity;
import com.example.travelmalaysia.Kedah.LagendaParkActivity;
import com.example.travelmalaysia.Kedah.SkybridgeActivity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class KedahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedah);

        CardView skyBridgeCardView = findViewById(R.id.skybridgeCardView);
        CardView lagendaParkCardView = findViewById(R.id.lagendaparkCardCardView);
        CardView gunungJeraiResortCardView = findViewById(R.id.gunungjerairesortCardView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        skyBridgeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KedahActivity.this, SkybridgeActivity.class);
                startActivity(intent);
            }
        });

        lagendaParkCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KedahActivity.this, LagendaParkActivity.class);
                startActivity(intent);

            }
        });

        gunungJeraiResortCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KedahActivity.this, GunungJeraiResortActivity.class);
                startActivity(intent);

            }
        });

    }
}