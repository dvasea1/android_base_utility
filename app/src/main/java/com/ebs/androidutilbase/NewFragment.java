package com.ebs.androidutilbase;

import android.view.View;

import com.ebs.android_base_utility.base.BaseFragment;

/**
 * Created by barbaros.vasile on 12/6/2017.
 */

public class NewFragment extends BaseFragment {

    public static NewFragment newInstance(){
        return new NewFragment();
    }
    @Override
    public int getLayoutResourceId() {
        return R.layout.new_fragment;
    }

    @Override
    public void onActivityCreated() {
        super.onActivityCreated();

    }
}
