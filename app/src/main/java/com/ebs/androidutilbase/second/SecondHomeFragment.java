package com.ebs.androidutilbase.second;

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

public class SecondHomeFragment
        extends BaseFragment {

    public static SecondHomeFragment newInstance() {

        Bundle args = new Bundle();

        SecondHomeFragment fragment = new SecondHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_home_fragment, container, false);
        System.out.println("XXXonCreateView FirstFragment");

        return view;
    }
}
