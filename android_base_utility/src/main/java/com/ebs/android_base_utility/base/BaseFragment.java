package com.ebs.android_base_utility.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ebs.android_base_utility.R;
import com.ebs.android_base_utility.base.util.LoadingView;
import com.ebs.android_base_utility.base.util.LocalBroadCastReceiver;
import com.ebs.android_base_utility.base.util.NavigationBar;
import com.ebs.android_base_utility.base.util.StatusBarUtil;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;


public abstract class BaseFragment extends SupportFragment implements BaseInterface {

    protected View view;
    protected View loadingView;
    protected LayoutInflater inflater;
    private BroadcastReceiver receiver;
    View topBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSoftInput();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(getLayoutResourceId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getNavigation((ViewGroup) view);
        if(topBar != null){
            if(topBar instanceof NavigationBar){
                StatusBarUtil.addStatus(getActivity(),(LinearLayout) topBar);
            }
        }
        createLoadingView(getRootLoadingViewResId());
    }

    private void getNavigation(ViewGroup parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                getNavigation((ViewGroup) child);
                if (child instanceof NavigationBar) {
                    topBar = child;
                    System.out.println("child is "+child);
                    break;
                }
            }
        }
    }
    private void createLoadingView(int resId){
        try {
            RelativeLayout rootView = view.findViewById(resId);
            if(rootView == null){
                loadingView = new LoadingView().getProgressBar(getActivity(),view,getLayoutResourceIdLoading());
            } else {
                loadingView = new LoadingView().getProgressBar(getActivity(),rootView,getLayoutResourceIdLoading());
            }
        } catch (Exception E){
            //
        }

    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity;
    }

    @Override
    public int getRootLoadingViewResId() {
        return 0;
    }

    @Override
    public int getLayoutResourceIdLoading() {
        return R.layout.loading_view;
    }


    public void registerBroadCastReceiver(final LocalBroadCastReceiver broadcastReceiver){
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                try{
                    if(getActivity() != null && intent.getExtras() != null){
                        broadcastReceiver.Receive(context,intent.getExtras().getString("action"),intent.getExtras().getString("sender"),intent.getExtras().getString("data"));
                    }
                } catch (Exception e){e.printStackTrace();}
            }
        };
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(receiver,new IntentFilter("filter"));
    }

    public void sendBroadCast(String action,Object o,String sender){
        Intent intent = new Intent("filter");
        intent.putExtra("action",action);
        intent.putExtra("data",new Gson().toJson(o));
        intent.putExtra("sender",sender);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideSoftInput();
        if(receiver!=null){
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
        }
    }
}