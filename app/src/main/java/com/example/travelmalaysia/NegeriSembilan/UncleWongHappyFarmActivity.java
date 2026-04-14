package com.example.travelmalaysia.NegeriSembilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travelmalaysia.Melaka.MenaraTamingSariActivity;
import com.example.travelmalaysia.R;

public class UncleWongHappyFarmActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uncle_wong_happy_farm);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_website) {

                    Toast.makeText(UncleWongHappyFarmActivity.this, "Website", Toast.LENGTH_SHORT).show();
                    Uri webpage = Uri.parse("https://www.traveloka.com/en-my/activities/malaysia/product/uncle-wong-happy-farm-atvutv-riding-experience-in-port-dickson-7080168281091");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if(webIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(webIntent);
                    } else{
                        Toast.makeText(UncleWongHappyFarmActivity.this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}