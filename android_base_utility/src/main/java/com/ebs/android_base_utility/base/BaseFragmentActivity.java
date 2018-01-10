package com.ebs.android_base_utility.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ebs.android_base_utility.base.util.LoadingView;
import com.ebs.android_base_utility.base.util.LocalBroadCastReceiver;
import com.ebs.android_base_utility.base.util.NavigationBar;
import com.ebs.android_base_utility.base.util.StatusBarUtil;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseFragmentActivity extends SupportActivity implements BaseInterface {

    protected View loadingView;
    protected SupportActivity thisActivity;
    private BroadcastReceiver receiver;
    private View topBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
        thisActivity= this;
        createLoadingView(getRootLoadingViewResId());

        StatusBarUtil.setStatusTintColor(thisActivity);
        getNavigation((ViewGroup) getWindow().getDecorView().getRootView());
        if(topBar != null){
            if(topBar instanceof NavigationBar){
                StatusBarUtil.addStatus(thisActivity,(LinearLayout) topBar);
            }
        }

    }

    private void getNavigation(ViewGroup parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                getNavigation((ViewGroup) child);
                if (child instanceof NavigationBar) {
                    topBar = child;
                    break;
                }
            }
        }
    }

    @Override
    public int getLayoutResourceId() {
        return 0;
    }

    @Override
    public int getRootLoadingViewResId() {
        return 0;
    }

    @Override
    public int getLayoutResourceIdLoading() {
        return 0;
    }

    private void createLoadingView(int resId){
        RelativeLayout rootView = findViewById(resId);
        loadingView = new LoadingView().getProgressBar(this,rootView,getLayoutResourceIdLoading());
    }
    public Context getDialogContext() {
        Context context;
        if (getParent() != null)
            context = getParent();
        else
            context = this;
        return context;
    }

    public void sendBroadCast(String action,Object o,String sender){
        Intent intent = new Intent("filter");
        intent.putExtra("action",action);
        intent.putExtra("data",new Gson().toJson(o));
        intent.putExtra("sender",sender);
        LocalBroadcastManager.getInstance(getDialogContext()).sendBroadcast(intent);
    }

    public void registerBroadCastReceiver(final LocalBroadCastReceiver broadcastReceiver){
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                try{
                    if(thisActivity != null && intent.getExtras() != null) {
                        broadcastReceiver.Receive(context,intent.getExtras().getString("action"),intent.getExtras().getString("sender"),intent.getExtras().getString("data"));
                    }
                } catch (Exception e){e.printStackTrace();}
            }
        };
        LocalBroadcastManager.getInstance(getDialogContext()).registerReceiver(receiver,new IntentFilter("filter"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(receiver!=null){
            LocalBroadcastManager.getInstance(getDialogContext()).unregisterReceiver(receiver);
        }
    }
}