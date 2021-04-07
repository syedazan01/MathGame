package com.example.mathgame;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int second = 60;
    TextView txttime;
    TextView txt_question;
    TextView txt_result;
    TextView txt_score;
    boolean isResultCorrect;
    int result;
    int score;
    boolean doublebacktoexitpressedonce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txttime = findViewById(R.id.time);
        txt_question = findViewById(R.id.txtQuestion);
        txt_result = findViewById(R.id.txtresult);
        txt_score =findViewById(R.id.txtscore);
        ImageButton right_click = findViewById(R.id.rightclick);
        ImageButton worng_click = findViewById(R.id.wrongclick);
        timer();
        genrateQuestion();



        right_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(true);

            }
        });

        worng_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(false);

            }
        });

    }




    private void genrateQuestion(){
        isResultCorrect = true;
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        result = a + b;
        float f = random.nextFloat();
        if (f > 0.5f) {
            result = random.nextInt(100);
            isResultCorrect = false;
        }
            txt_question.setText(a + " + " + b );
            txt_result.setText("= " + result);

    }

    private void verifyAnswer(boolean answer){
        if (answer == isResultCorrect){
            score += 5;
            txt_score.setText("SCORE :"+ score);
        }
        else {
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
        genrateQuestion();
    }

    private void timer()
    {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                txttime.setText("Time : "+second);
                if (second > 0){
                    second--;
                    handler.postDelayed(this,1000);

                }
                else{
                    if (second ==0){
                        Intent i = new Intent(MainActivity.this,score.class);
                        //i.setType("text/plain");
                        i.putExtra("score",score);
                        startActivity(i);
                    }
                }

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

