package com.example.travelmalaysia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.travelmalaysia.R;

public class SettingActivity extends AppCompatActivity {

    TextView tv_language;
    LinearLayout ll_language, ll_notification, ll_offline;
    Switch switch_notification, switch_download;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String SP_LANGUAGE = "language";
    String SP_NOTIFICATION = "notification";
    String SP_DOWNLOAD = "download";
    String[] values = {"English", "Melayu", "Chinese", "Tamil"};
    AlertDialog alertDialog;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tv_language = findViewById(R.id.tv_language);
        switch_notification = findViewById(R.id.switch_noti);
        switch_download = findViewById(R.id.switch_download);
        ll_language = findViewById(R.id.ll_setting_language);
        ll_notification = findViewById(R.id.ll_setting_notification);
        ll_offline = findViewById(R.id.ll_setting_offline);

        sharedPref = getSharedPreferences("app settings", MODE_PRIVATE);
        editor = sharedPref.edit();

        switch_notification.setChecked(sharedPref.getBoolean(SP_NOTIFICATION,false)) ;
        tv_language.setText(values[sharedPref.getInt(SP_LANGUAGE, 0)]);
        switch_download.setChecked(sharedPref.getBoolean(SP_DOWNLOAD, false));

        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                editor.putBoolean(SP_NOTIFICATION, b);
                editor.commit();
            }
        });

        switch_download.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                editor.putBoolean(SP_DOWNLOAD, b);
                editor.commit();
            }
        });

        ll_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean switchState = switch_notification.isChecked();
                switch_notification.setChecked(!switchState);
                editor.putBoolean(SP_NOTIFICATION,!switchState);
                editor.commit();
            }
        });

        ll_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLanguageOptions();
            }
        });
    }

    public void ShowLanguageOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
        builder.setTitle("Select your language");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i){
                    case 0:
                        editor.putInt(SP_LANGUAGE,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_LANGUAGE,1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_LANGUAGE,2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_LANGUAGE,3);
                        editor.commit();
                        break;
                }
                alertDialog.dismiss();
                tv_language.setText(values[sharedPref.getInt(SP_LANGUAGE, 0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}