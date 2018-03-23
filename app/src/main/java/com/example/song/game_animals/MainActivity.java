package com.example.song.game_animals;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CommonFunc commonFunc = new CommonFunc();
    public int count,life;
    public int TotalNum = 5;
    public int AnimalCount = 4;
    public int RightAnswer_Id;
    public static  int[] IdList = new int[]{R.id.left_top_image, R.id.right_top_image, R.id.left_bottom_image,
            R.id.right_bottom_image};

    public static int[] AnimalList = {R.drawable.bird,R.drawable.cat,R.drawable.fish,R.drawable.flower,
            R.drawable.honey,R.drawable.house,R.drawable.smile,R.drawable.sun};

    public static String[] AnimalString  = {"bird","cat","fish","flower","honey","house","smile","sun"};

    public ArrayList<String> CurString = new ArrayList<String>();

    public Button button_animal;
    public ImageView[] ImageView_List = new ImageView[AnimalCount];

//    public void SetImage(String filename, int id,int mode) {
//        View view = findViewById(id);
//        InputStream is = null;
//        try {
//            is = getAssets().open(filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Drawable drawable = Drawable.createFromStream(is,null);
//        if(mode == 0){
//            view.setBackground(drawable);
//        }
//        else{
//            ((ImageView) view).setImageDrawable(drawable);
//        }
//    }

    public  void InitWidget(){
        button_animal = (findViewById(R.id.button_animal));
        SetFonts("Fonts/04B_03.TTF",R.id.button_animal);

        for(int i = 0; i  < AnimalCount; ++i)
            ImageView_List[i] = findViewById(IdList[i]);

    }

    public void SetFonts(String filename, int id){
        TextView view = findViewById(id);
        Typeface typeface = Typeface.createFromAsset(getAssets(),filename);
        view.setTypeface(typeface);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Intent intent = getIntent();
        //  Get the state of game
        count = intent.getIntExtra("count",0);
        life = intent.getIntExtra("life",2);
        TextView lifeNum = findViewById(R.id.LifeNum);
        lifeNum.setText(life + "");

        // Init the Widgets
        InitWidget();

        // randomly choose the animal
        int Len = AnimalList.length;

        Random random = new Random();
        List<Integer> CurList = new ArrayList<Integer>();
        List<Integer> TmpList = new ArrayList<Integer>();
        for(int i = 0 ; i < AnimalCount; ++i){
            int pos = random.nextInt(Len);
            if(! TmpList.contains(pos)){            // make sure not to choose the same animal
                TmpList.add(pos);
                CurList.add(pos);
                CurString.add(AnimalString[pos]);
            }
            else --i;
        }

        // set the image of animal
        for(int i = 0 ; i < AnimalCount ; ++i){
            int pos = CurList.get(i);
            ImageView_List[i].setImageDrawable(getResources().getDrawable(AnimalList[pos]));
        }

        int index = random.nextInt(AnimalCount);
        RightAnswer_Id = IdList[index];
        button_animal.setText(CurString.get(index));

    }

    public void ClickBtn(View view) {
        int CurId = view.getId();
        count = count + 1;
        if(CurId != RightAnswer_Id){
            life = life - 1;
            view.setBackgroundColor(Color.RED);
        }
        else{
            view.setBackgroundColor(Color.GREEN);
        }
        Log.d("LIFEIS",life + " ");

        if(life <= 0){
            Toast.makeText(this,"LOSE!",Toast.LENGTH_LONG).show();
            // go to end activity
            Intent intent = new Intent(this,Lose.class);
            this.finish();
            startActivity(intent);
            return;
        }
        else if(count > TotalNum){
            Toast.makeText(this,"WIN!",Toast.LENGTH_LONG).show();
            // go to win activity
            Intent intent = new Intent(this,Win.class);
            this.finish();
            startActivity(intent);
            return;
        }
        else{
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("count",count);
            intent.putExtra("life",life);
            this.finish();
            startActivity(intent);
        }

    }
}
