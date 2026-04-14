package com.example.travelmalaysia.KualaLumpur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travelmalaysia.Perak.IpohWorldActivity;
import com.example.travelmalaysia.R;

public class SultanAbdulSamadActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sultan_abdul_samad);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_website) {

                    Toast.makeText(SultanAbdulSamadActivity.this, "Website", Toast.LENGTH_SHORT).show();
                    Uri webpage = Uri.parse("https://www.tripadvisor.com/Attraction_Review-g298570-d456562-Reviews-Sultan_Abdul_Samad_Building-Kuala_Lumpur_Wilayah_Persekutuan.html");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if(webIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(webIntent);
                    } else{
                        Toast.makeText(SultanAbdulSamadActivity.this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}