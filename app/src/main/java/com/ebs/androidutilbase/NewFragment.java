package com.ebs.androidutilbase;

import android.os.Bundle;
import android.view.View;

import com.ebs.android_base_utility.base.BaseFragment;

import butterknife.OnClick;

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
    public int getLayoutResourceIdLoading() {
        return R.layout.loading;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadingView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.bac) void click(){
        extraTransaction().setCustomAnimations(R.anim.fragment_slide_in_bottom,R.anim.v_fragment_pop_exit,R.anim.v_fragment_pop_enter,R.anim.fragment_slide_out_bottom).start(FragmentPopup.newInstance());
        //((MainActivity)getActivity()).startPopup();
    }
    @OnClick(R.id.left) void left(){
        start(MyFragment.newInstance());
    }

    /*   @Override
    public void onActivityCreated() {
        super.onActivityCreated();
        view.findViewById(R.id.bac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).change();
            }
        });
    }*/
}
