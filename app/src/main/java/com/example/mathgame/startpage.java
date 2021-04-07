package com.example.mathgame;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class startpage extends AppCompatActivity {
    boolean doublebacktoexitpressedonce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        ImageButton play_button = findViewById(R.id.playbutton);
        ImageButton share_button = findViewById(R.id.sharebutton);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(startpage.this,MainActivity.class);
                startActivity(i);

            }
        });
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(i.EXTRA_TEXT,"Maths Game - Fun Way To Learn Maths. http:www.play.google.com");
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if(doublebacktoexitpressedonce){
            super.onBackPressed();
            return;
        }
        this.doublebacktoexitpressedonce=true;
        Toast.makeText(this, "Please Click Back Again To Exit", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doublebacktoexitpressedonce = false;
            }
        },2000);
    }





}
