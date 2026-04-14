package com.example.travelmalaysia.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelmalaysia.Johor.JurassicActivity;
import com.example.travelmalaysia.Johor.LegolandActivity;
import com.example.travelmalaysia.Johor.SeaLifeActivity;
import com.example.travelmalaysia.Penang.EntopiaActivity;
import com.example.travelmalaysia.Penang.EscapeActivity;
import com.example.travelmalaysia.Penang.TropicalSpiceGardenActivity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PenangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penang);

        CardView escapeCardView = findViewById(R.id.escapeCardView);
        CardView entopiaCardView = findViewById(R.id.entopiaCardView);
        CardView tropicalspicegardenCardView = findViewById(R.id.tropicalspicegardenCardView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        escapeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PenangActivity.this, EscapeActivity.class);
                startActivity(intent);
            }
        });

        entopiaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PenangActivity.this, EntopiaActivity.class);
                startActivity(intent);
            }
        });

        tropicalspicegardenCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PenangActivity.this, TropicalSpiceGardenActivity.class);
                startActivity(intent);

            }
        });

    }
}