package com.example.song.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class StartActivity extends AppCompatActivity {
    public final static String GlobalString = "Activity.GlobalString";
    CommonFunc commonFunc = new CommonFunc();

    public void SetFonts(String filename, int id){
        TextView view = findViewById(id);
        Typeface typeface = Typeface.createFromAsset(getAssets(),filename);
        view.setTypeface(typeface);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        String font_playbutton = "Fonts/04B_03.TTF";
        SetFonts(font_playbutton,R.id.button_play);
        SetFonts(font_playbutton,R.id.button_exit);
    }


        public void BeginGame(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        intent.putExtra("count",0);
        intent.putExtra("life",3);
        startActivity(intent);
    }

    public void ExitGame(View view) {
        finish();
    }
}
