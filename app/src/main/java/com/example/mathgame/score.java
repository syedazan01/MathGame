package com.example.mathgame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView score_txt = findViewById(R.id.txtscore);


        int score = getIntent().getIntExtra("score",0);
        score_txt.setText("SCORE : "+ score);



        ImageButton score_share = findViewById(R.id.scoreshare);
        score_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(i.EXTRA_TEXT,".http:www.play.google.com");
                startActivity(i);


            }
        });
    }
}
