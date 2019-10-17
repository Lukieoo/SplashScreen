package com.anioncode.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    TextView view;
    ProgressBar bar;
    GifImageView gifImageView;
    static int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=findViewById(R.id.text);
        bar=findViewById(R.id.progressBar);
        gifImageView=findViewById(R.id.gifImageView);

        new CountDownTimer(6000,60){

            @Override
            public void onTick(long millisUntilFinished) {
               counter++;
                view.setText(counter+" %");
            }

            @Override
            public void onFinish() {

                view.setText("Complete");
                bar.setVisibility(View.GONE);
                gifImageView.setImageResource(R.drawable.hero);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,Something.class);
                        MainActivity.this.startActivity(intent);
                        MainActivity.this.finish();
                    }
                },1000);
            }
        }.start();

    }
}
