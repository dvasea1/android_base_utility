package com.ebs.androidutilbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ebs.android_base_utility.base.BaseFragment;

/**
 * Created by barbaros.vasile on 3/21/2018.
 */

public class TestFrag extends BaseFragment {
    public static TestFrag newInstance() {
        
        Bundle args = new Bundle();
        
        TestFrag fragment = new TestFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.first_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
