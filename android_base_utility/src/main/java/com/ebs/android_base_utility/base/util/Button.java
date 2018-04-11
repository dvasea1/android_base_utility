package com.ebs.android_base_utility.base.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.ebs.android_base_utility.R;

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
    void init(){
       /* if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator sla = AnimatorInflater.loadStateListAnimator(getContext(), R.animator.button_elevation);
            setStateListAnimator(sla);
        }*/
       setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {
               animateButton();
           }
       });
    }

    void animateButton() {
        // Load the animation
        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
       /* double animationDuration = 2f * 1000;
        myAnim.setDuration((long)animationDuration);*/

        // Use custom animation interpolator to achieve the bounce effect
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07f, 20f);

        myAnim.setInterpolator(interpolator);

        // Animate the button
        startAnimation(myAnim);

       /* // Run button animation again after it finished
        myAnim.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {}

            @Override
            public void onAnimationRepeat(Animation arg0) {}

            @Override
            public void onAnimationEnd(Animation arg0) {
                //animateButton();
            }
        });*/
    }
}