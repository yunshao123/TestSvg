package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
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
    TextView textView;
    ImageView imageView;
    Button button;
    Button buttonStop;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvShow);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        buttonStop = findViewById(R.id.button2);
//        startAnim(imageView);
//
//        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.alpha);
//        animator.setInterpolator(new LinearInterpolator());
//        Animator animator2 = AnimatorInflater.loadAnimator(this,R.animator.rotation);
//        final AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(animator,animator2);
//        animatorSet.setTarget(imageView);
//        animatorSet.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha2);
                animator.setTarget(imageView);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animation.cancel();
                        animatorSet.cancel();
                    }

                });
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha);
                animator.setInterpolator(new LinearInterpolator());
                Animator animator2 = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.rotation);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator,animator2);
                animatorSet.setTarget(imageView);
                animatorSet.start();
            }
        });
    }

    /**
     * 启动动画
     *
     * @param iv
     */
    private void startAnim(ImageView iv) {
        Drawable drawable = iv.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
