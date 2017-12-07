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
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;

public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setFragmentAnimator(new DefaultHorizontalAnimator());

        loadRootFragment(R.id.fl_container,MainTabHostFragment.newInstance());
    }
}
