package com.example.song.game_animals;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        SetFonts("Fonts/04B_03.TTF",R.id.button_Win_Again);
    }

    public void SetFonts(String filename, int id){
        TextView view = findViewById(id);
        Typeface typeface = Typeface.createFromAsset(getAssets(),filename);
        view.setTypeface(typeface);
    }

    public void Return(View view) {
        finish();
    }
}
