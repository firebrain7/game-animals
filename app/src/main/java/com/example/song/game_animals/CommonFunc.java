package com.example.song.game_animals;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by SONG on 2018/3/22.
 */

public class CommonFunc extends AppCompatActivity {

    // read the assets file and set the fonts of view
    public void SetFonts(String filename, int id){
        TextView view = findViewById(id);
        Typeface typeface = Typeface.createFromAsset(getAssets(),filename);
        view.setTypeface(typeface);
    }
}
