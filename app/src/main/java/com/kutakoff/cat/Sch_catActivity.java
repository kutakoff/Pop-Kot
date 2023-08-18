package com.kutakoff.cat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sch_catActivity extends AppCompatActivity {
    private ImageView imageClose, imageOpen, click;
    private MediaPlayer closeSound, openSound;
    long sch = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch_cat);
        TextView textCount = findViewById(R.id.textCount);
        imageClose = findViewById(R.id.image_close);
        imageOpen = findViewById(R.id.image_open);
        click = findViewById(R.id.click);

        closeSound = MediaPlayer.create(this, R.raw.pop_cat);
        openSound = MediaPlayer.create(this, R.raw.pop_cat);

        imageClose.setOnClickListener(v -> {
            textCount.setText("" + (sch += 1));
            imageClose.setVisibility(View.INVISIBLE);
            imageOpen.setVisibility(View.VISIBLE);
            soundPlay(closeSound);
            if (sch > 0) {
                click.setVisibility(View.INVISIBLE);
            } else {
                click.setVisibility(View.VISIBLE);
            }
        });

        imageOpen.setOnClickListener(v -> {
            soundPlay(openSound);
            textCount.setText("" + (sch += 1));
            imageClose.setVisibility(View.VISIBLE);
            imageOpen.setVisibility(View.INVISIBLE);
        });
    }

    public void soundPlay(MediaPlayer sound) {
        sound.start();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите выйти из приложения? Весь прогресс будет потерян.")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> finish()).setNegativeButton("Нет", null).show();
    }
}