package com.ebs.androidutilbase.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebs.android_base_utility.base.BaseFragment;
import com.ebs.androidutilbase.R;
import com.ebs.androidutilbase.first.FirstHomeFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by barbaros.vasile on 11/16/2017.
 */

public class SecondFragment extends BaseFragment {

    public static SecondFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(FirstHomeFragment.class) == null) {
            loadRootFragment(R.id.second_container, SecondHomeFragment.newInstance());
        }
    }
}