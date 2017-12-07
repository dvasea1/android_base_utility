package com.ebs.androidutilbase.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ebs.android_base_utility.base.BaseFragment;
import com.ebs.androidutilbase.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by barbaros.vasile on 11/16/2017.
 */

public class FirstFragment extends BaseFragment {

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.first_fragment;
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        if (findChildFragment(FirstHomeFragment.class) == null) {
            loadRootFragment(R.id.first_container, FirstHomeFragment.newInstance());
        }
    }
}