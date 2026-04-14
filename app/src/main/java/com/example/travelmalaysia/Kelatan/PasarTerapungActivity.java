package com.example.travelmalaysia.Kelatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travelmalaysia.Melaka.MenaraTamingSariActivity;
import com.example.travelmalaysia.R;

public class PasarTerapungActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasar_terapung);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_website) {

                    Toast.makeText(PasarTerapungActivity.this, "Website", Toast.LENGTH_SHORT).show();
                    Uri webpage = Uri.parse("https://tourism.kelantan.my/index.php/ms/pelancongan/alam-semulajadi/kolam-air-panas-2/datu");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if(webIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(webIntent);
                    } else{
                        Toast.makeText(PasarTerapungActivity.this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}