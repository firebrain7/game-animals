package com.example.song.game_animals;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity {


    public void SetFonts(String filename, int id){
        TextView view = findViewById(id);
        Typeface typeface = Typeface.createFromAsset(getAssets(),filename);
        view.setTypeface(typeface);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        SetFonts("Fonts/04B_03.TTF",R.id.button_Lose_Again);
    }

    public void Return(View view) {
        finish();
    }
}
