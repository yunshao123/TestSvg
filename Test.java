package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;

public class Test {
    Animator animator = AnimatorInflater.loadAnimator(this,R.animator.alpha);
        animator.setInterpolator(new LinearInterpolator());
    Animator animator2 = AnimatorInflater.loadAnimator(this,R.animator.rotation);
    final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator,animator2);
        animatorSet.setTarget(imageView);
        animatorSet.start();

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.alpha2);
            animator.setTarget(imageView);
            animator.start();
        }
    });
}
