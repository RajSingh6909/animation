package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnrclock,btnblink,btnside;
    private Button btnrantick,bntNext;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrclock = (Button) findViewById(R.id.btnRClk);
        btnrantick = (Button) findViewById(R.id.btnRAClk);
        bntNext=findViewById(R.id.btnNext);
        bntNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PopUPActivity.class));
            }
        });
        btnblink=findViewById(R.id.btnblink);
        btnside=findViewById(R.id.btnside);
        img = (ImageView) findViewById(R.id.imgvw);
        btnrclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
                img.startAnimation(aniRotateClk);
            }
        });
        btnrantick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotateAclk = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
                img.startAnimation(animRotateAclk);
            }
        });

        btnside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.side);
                img.startAnimation(aniRotateClk);
            }
        });
        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotateAclk = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                img.startAnimation(animRotateAclk);

            }
        });
    }
}