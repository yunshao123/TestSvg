package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    Button button;
    Button buttonStop;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        button = findViewById(R.id.button);
        buttonStop = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageView.getVisibility() == View.VISIBLE){
                    stopAnimator(imageView);
                }
                if (imageView2.getVisibility() == View.VISIBLE){
                    stopAnimator(imageView2);
                }
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setVisibility(View.VISIBLE);
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha_fade_in);
                Animator animator2 = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.rotation);
                animator2.setInterpolator(new LinearInterpolator());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator,animator2);
                animatorSet.setTarget(imageView2);
                animatorSet.start();

                imageView.setVisibility(View.VISIBLE);
                Animator animator3 = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha_fade_in);
                Animator animator4 = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animator3,animator4);
                animatorSet2.setTarget(imageView);
                animatorSet2.start();

            }
        });
    }

    private void stopAnimator(final ImageView imageViewShow){
        Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha2);
        animator.setTarget(imageViewShow);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (imageViewShow instanceof ImageView){
                    // 处理该view的动画集合取消事件
                }
                imageViewShow.setVisibility(View.GONE);
                animation.cancel();
            }
        });
    }
}
