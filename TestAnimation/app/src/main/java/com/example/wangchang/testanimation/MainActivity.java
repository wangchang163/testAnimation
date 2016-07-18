package com.example.wangchang.testanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);
        findViewById(R.id.tv4).setOnClickListener(this);
        findViewById(R.id.tv5).setOnClickListener(this);


    }

    public void testAlpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alphaanimation);
        tv.startAnimation(animation);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
//        tv.startAnimation(alphaAnimation);

    }

    public void testRotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotateanimation);
        tv.startAnimation(animation);
    }

    public void testTranslate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translateanimation);
        tv.startAnimation(animation);
    }

    public void testScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scaleanimation);
        tv.startAnimation(animation);
    }

    public void animationSets() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.setanimation);
        tv.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                testAlpha();
                break;
            case R.id.tv2:
                testRotate();
                break;
            case R.id.tv3:
                testTranslate();
                break;
            case R.id.tv4:
                testScale();
                break;
            case R.id.tv5:
                animationSets();
                break;

        }
    }
}
