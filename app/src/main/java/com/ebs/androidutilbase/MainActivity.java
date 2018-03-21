package com.ebs.androidutilbase;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ebs.android_base_utility.base.BaseFragmentActivity;
import com.ebs.android_base_utility.base.recyclerview_utils.RecyclerLazyLoad;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;

public class MainActivity extends BaseFragmentActivity {
    TestFrag supportFragment;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportFragment= TestFrag.newInstance();

        setFragmentAnimator(new DefaultHorizontalAnimator());

        loadRootFragment(R.id.fl_container,supportFragment,false,false);
    }

    public void startPopup(){
       /* getTopFragment().getFragmentAnimator().setPopEnter(0);
        getTopFragment().getFragmentAnimator().setPopExit(0);
        getTopFragment().getFragmentAnimator().setExit(0);
        getTopFragment().getFragmentAnimator().setEnter(0);*/
       // SupportFragment supportFragment = FragmentPopup.newInstance();
      // / supportFragment.setFragmentAnimator(new VerticalAnimator());
        //showHideFragment(FragmentPopup.newInstance());
       // start(supportFragment);
        extraTransaction().setCustomAnimations(R.anim.fragment_slide_in_bottom,0,0,R.anim.fragment_slide_out_bottom).start(FragmentPopup.newInstance());
      //  changeFragmentPopup(R.id.fl_container,FragmentPopup.newInstance(),true,true,false);
    }
}
