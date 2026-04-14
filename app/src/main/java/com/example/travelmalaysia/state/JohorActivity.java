package com.example.travelmalaysia.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelmalaysia.Johor.JurassicActivity;
import com.example.travelmalaysia.Johor.LegolandActivity;
import com.example.travelmalaysia.Johor.SeaLifeActivity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class JohorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_johor);

        CardView legolandCardView = findViewById(R.id.legolandCardView);
        CardView jurassicParkCardView = findViewById(R.id.jurassicCardView);
        CardView seaLifeCardView = findViewById(R.id.seaLifeCardView);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        legolandCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JohorActivity.this, LegolandActivity.class);
                startActivity(intent);
            }
        });

        jurassicParkCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JohorActivity.this, JurassicActivity.class);
                startActivity(intent);
            }
        });

        seaLifeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(JohorActivity.this, SeaLifeActivity.class);
                startActivity(intent);

            }
        });
    }
}