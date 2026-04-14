package com.example.travelmalaysia.Johor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.travelmalaysia.R;

public class LegolandActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legoland);

        btnWebsite = findViewById(R.id.btn_website);

        btnWebsite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_website) {
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
            Uri webpage = Uri.parse("http://www.legoland.com.my");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            if(webIntent.resolveActivity(getPackageManager()) != null){
                startActivity(webIntent);
            } else{
                Toast.makeText(this, "Sorry, there is problem", Toast.LENGTH_SHORT).show();
            }

        }
    }
}