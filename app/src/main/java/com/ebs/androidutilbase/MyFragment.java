package com.ebs.androidutilbase;

import android.os.Bundle;
import android.view.View;

import com.ebs.android_base_utility.base.BaseFragment;
import com.ebs.android_base_utility.base.recyclerview_utils.RecyclerLazyLoad;

/**
 * Created by barbaros.vasile on 10/5/2017.
 */

public class MyFragment extends BaseFragment {

    RecyclerLazyLoad recyclerLazyLoad;
    private AdapterTest adapter;

    public static MyFragment newInstance(){
        return new MyFragment();
    }
    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).change();
            }
        });
    }

    @Override
    public void onActivityCreated() {
        super.onActivityCreated();

    }

    private void initAdapter(){
            //adapter = new AdapterTest()
    }
}
