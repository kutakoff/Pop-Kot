package com.kutakoff.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Sch_catActivity extends AppCompatActivity {
    private ImageView imageclose, imageopen, click;
    private MediaPlayer closeSound, openSound;
    int sch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch_cat);
        TextView textView = findViewById(R.id.textView);
        Button button_back = findViewById(R.id.button_back);
        imageclose = findViewById(R.id.image_close);
        imageopen = findViewById(R.id.image_open);
        click = findViewById(R.id.click);
        closeSound = MediaPlayer.create(this, R.raw.pop_cat);
        openSound = MediaPlayer.create(this, R.raw.pop_cat);
        imageclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("" + (sch += 1));
                imageclose.setVisibility(View.INVISIBLE);
                imageopen.setVisibility(View.VISIBLE);
                soundPlay(closeSound);
                if (sch > 0) {
                    click.setVisibility(View.INVISIBLE);
                }
                else {
                    click.setVisibility(View.VISIBLE);
                }
            }
        });
        imageopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(openSound);
                textView.setText("" + (sch += 1));
                imageclose.setVisibility(View.VISIBLE);
                imageopen.setVisibility(View.INVISIBLE);
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void soundPlay (MediaPlayer sound) {
    sound.start();
    }
}