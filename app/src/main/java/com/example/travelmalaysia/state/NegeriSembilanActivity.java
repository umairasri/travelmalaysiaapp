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
import com.example.travelmalaysia.NegeriSembilan.JelitaOstrichActivity;
import com.example.travelmalaysia.NegeriSembilan.UluBendulActivity;
import com.example.travelmalaysia.NegeriSembilan.UncleWongHappyFarmActivity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class NegeriSembilanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negeri_sembilan);

        CardView card1 = findViewById(R.id.jelitaostrichCardView);
        CardView card2 = findViewById(R.id.ulubendulCardView);
        CardView card3 = findViewById(R.id.unclewonghappyfarmCardView);

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
                Intent intent = new Intent(NegeriSembilanActivity.this, JelitaOstrichActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NegeriSembilanActivity.this, UluBendulActivity.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NegeriSembilanActivity.this, UncleWongHappyFarmActivity.class);
                startActivity(intent);

            }
        });

    }
}