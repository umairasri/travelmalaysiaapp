package com.example.travelmalaysia.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.travelmalaysia.Penang.EntopiaActivity;
import com.example.travelmalaysia.Penang.EscapeActivity;
import com.example.travelmalaysia.Penang.TropicalSpiceGardenActivity;
import com.example.travelmalaysia.Perak.IpohWorldActivity;
import com.example.travelmalaysia.Perak.LostWorldTambunActivity;
import com.example.travelmalaysia.Perak.PangkorIslandActivity;
import com.example.travelmalaysia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PerakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perak);

        CardView lostworldtambunCardView = findViewById(R.id.lostworldtambunCardView);
        CardView pangkorislandCardView = findViewById(R.id.pangkorislandCardView);
        CardView ipohworldCardView = findViewById(R.id.ipohworldCardView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        lostworldtambunCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerakActivity.this, LostWorldTambunActivity.class);
                startActivity(intent);
            }
        });

        pangkorislandCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerakActivity.this, PangkorIslandActivity.class);
                startActivity(intent);
            }
        });

        ipohworldCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PerakActivity.this, IpohWorldActivity.class);
                startActivity(intent);

            }
        });

    }
}