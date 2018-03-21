package com.ebs.android_base_utility.base.util;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
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
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator sla = AnimatorInflater.loadStateListAnimator(getContext(), R.animator.button_elevation);
            setStateListAnimator(sla);
        }
    }
}