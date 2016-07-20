package com.example.wangchang.testanimation2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon = (ImageView) findViewById(R.id.icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                rotate();
//                valuesHolderSet();
//                animationset();
                valueanimator();
            }
        });
    }

    public void rotate() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(icon, "rotation", 360f);
        animator.setDuration(2000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        animator.start();
    }

    public void valuesHolderSet() {
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationY", 0,200f);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f);
        PropertyValuesHolder p4 = PropertyValuesHolder.ofFloat("scaleY", 1f, 2f);
        PropertyValuesHolder p5 = PropertyValuesHolder.ofFloat("rotation", 0, 360f);
        ObjectAnimator.ofPropertyValuesHolder(icon,p1,p2,p3,p4,p5).setDuration(2000).start();
    }
    public void animationset(){
        ObjectAnimator animator1=ObjectAnimator.ofFloat(icon,"translationY",300f);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(icon,"alpha",0f, 1f);
        ObjectAnimator animator3=ObjectAnimator.ofFloat(icon,"scaleX",0f, 1f);
        ObjectAnimator animator4=ObjectAnimator.ofFloat(icon,"scaleY",0f, 1f);
        ObjectAnimator animator5=ObjectAnimator.ofFloat(icon,"rotation",0,720f);
        AnimatorSet set=new AnimatorSet();
        set.setDuration(2000);

        set.playTogether(animator1,animator2,animator3,animator4,animator5);
        set.start();
    }

    public void valueanimator(){
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0f,360f);
        valueAnimator.setTarget(icon);//绑定view
        //这时候我们并不知道要执行什么效果的动画，因为我们没有设置动画属性，这时候用到动画监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value= (Float) animation.getAnimatedValue();
                //拿到值来做相应的动画操作
                icon.setRotation(value);//旋转操作
                float fractionValue = animation.getAnimatedFraction();
                icon.setAlpha(fractionValue);
                icon.setTranslationX(value);//位移操作等等
            }
        });
        valueAnimator.setDuration(2000).start();
    }
}
