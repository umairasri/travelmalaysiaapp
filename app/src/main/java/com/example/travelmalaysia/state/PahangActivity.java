package com.example.travelmalaysia.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelmalaysia.Kelatan.MinFirefliesActivity;
import com.example.travelmalaysia.Kelatan.MuziumNegeriActivity;
import com.example.travelmalaysia.Kelatan.PasarTerapungActivity;
import com.example.travelmalaysia.Pahang.FraserHIllActivity;
import com.example.travelmalaysia.Pahang.GentingThemeParkActivity;
import com.example.travelmalaysia.Pahang.Kuantan118Activity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PahangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pahang);

        CardView card1 = findViewById(R.id.fraserhillCardView);
        CardView card2 = findViewById(R.id.gentingthemeCardView);
        CardView card3 = findViewById(R.id.kuantan118CardView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PahangActivity.this, FraserHIllActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PahangActivity.this, GentingThemeParkActivity.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PahangActivity.this, Kuantan118Activity.class);
                startActivity(intent);

            }
        });

    }
}