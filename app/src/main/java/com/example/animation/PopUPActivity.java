package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PopUPActivity extends AppCompatActivity {
    private Button close,gps;
    LinearLayout lichild,liparent;
    ImageView icon;
    Animation animation,iconAnimation,imgAnimation,closeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        getSupportActionBar().hide();

        gps=findViewById(R.id.btnActivate);
        close=findViewById(R.id.btnclose);

        lichild=findViewById(R.id.liChild);
        liparent=findViewById(R.id.liParent);

        icon=findViewById(R.id.icon);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromsmall);
        iconAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromicon);
        imgAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.forimageicon);
        closeAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close);

        liparent.setAlpha(0);
        lichild.setAlpha(0);
        icon.setVisibility(View.GONE);

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon.setVisibility(View.VISIBLE);
                icon.setAnimation(imgAnimation);


                lichild.setAlpha(1);
                lichild.startAnimation(iconAnimation);

                liparent.setAlpha(1);
                liparent.startAnimation(animation);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                icon.setVisibility(View.GONE);
                icon.setAnimation(closeAnimation);
                lichild.startAnimation(closeAnimation);
                liparent.startAnimation(closeAnimation);

                ViewCompat.animate(liparent).setStartDelay(1000).alpha(0).start();
                ViewCompat.animate(lichild).setStartDelay(1000).alpha(0).start();
            }
        });
    }
}
