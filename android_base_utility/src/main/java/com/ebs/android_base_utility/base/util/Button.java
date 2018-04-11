package com.ebs.android_base_utility.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.ebs.android_base_utility.R;

import butterknife.ButterKnife;

/**
 * Created by Vasile-barbaros-Pc on 9/15/2016.
 */
public class Button extends RelativeLayout {

    public Button(Context context) {
        super(context);
        init();
    }
    public Button(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }
    public Button(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }
    void init() {

       setOnTouchListener(new OnTouchListener() {
           @SuppressLint("ClickableViewAccessibility")
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               if(event.getAction() == MotionEvent.ACTION_UP){
                   animateButton();
               }
               return true;
           }
       });
    }

    void animateButton() {
        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07f, 20f);
        myAnim.setInterpolator(interpolator);
        startAnimation(myAnim);
    }
}