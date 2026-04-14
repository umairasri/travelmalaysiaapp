package com.example.travelmalaysia.Perak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travelmalaysia.Johor.JurassicActivity;
import com.example.travelmalaysia.R;

public class IpohWorldActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipoh_world);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_website) {

                    Toast.makeText(IpohWorldActivity.this, "Website", Toast.LENGTH_SHORT).show();
                    Uri webpage = Uri.parse("https://www.tripadvisor.com.my/Attraction_Review-g298298-d7806166-Reviews-Ipoh_World_at_Han_Chin_Pet_Soo-Ipoh_Kinta_District_Perak.html");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if(webIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(webIntent);
                    } else{
                        Toast.makeText(IpohWorldActivity.this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}