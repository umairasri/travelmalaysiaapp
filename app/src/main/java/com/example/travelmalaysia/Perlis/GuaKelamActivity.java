package com.example.travelmalaysia.Perlis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travelmalaysia.Perak.IpohWorldActivity;
import com.example.travelmalaysia.R;

public class GuaKelamActivity extends AppCompatActivity {

    Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gua_kelam);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_website) {

                    Toast.makeText(GuaKelamActivity.this, "Website", Toast.LENGTH_SHORT).show();
                    Uri webpage = Uri.parse("https://www.tripadvisor.com.my/Attraction_Review-g6898342-d7624808-Reviews-Gua_Kelam-Kaki_Bukit_Perlis.html");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if(webIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(webIntent);
                    } else{
                        Toast.makeText(GuaKelamActivity.this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}