package com.ebs.androidutilbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;

import com.ebs.android_base_utility.base.BaseFragment;

import butterknife.OnClick;

/**
 * Created by barbaros.vasile on 12/11/2017.
 */

public class FragmentPopup extends BaseFragment {
    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_popup;
    }

    public static FragmentPopup newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentPopup fragment = new FragmentPopup();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onEnterAnimationEnd(Bundle savedInstanceState) {
        super.onEnterAnimationEnd(savedInstanceState);
        System.out.println("animation end");
    }

    @OnClick(R.id.back) void backCLick(){
        pop();
    }
    @OnClick(R.id.newfrag) void neCLick(){
        start(MyFragment.newInstance());
    }
}