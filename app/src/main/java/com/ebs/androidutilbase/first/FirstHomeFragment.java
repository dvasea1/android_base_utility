package com.ebs.androidutilbase.first;

import android.os.Bundle;

import com.ebs.android_base_utility.base.BaseFragment;
import com.ebs.androidutilbase.NewFragment;
import com.ebs.androidutilbase.R;

import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by barbaros.vasile on 11/16/2017.
 */

public class FirstHomeFragment extends BaseFragment {

    public static FirstHomeFragment newInstance() {

        Bundle args = new Bundle();

        FirstHomeFragment fragment = new FirstHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutResourceId() {
        return R.layout.first_home;
    }

    @OnClick(R.id.button) void click(){
        ((SupportFragment)( getParentFragment()).getParentFragment()).start(NewFragment.newInstance());
    }
}