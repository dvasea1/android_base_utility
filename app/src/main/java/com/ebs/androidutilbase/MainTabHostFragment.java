package com.ebs.androidutilbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ebs.androidutilbase.base.BottomBar;
import com.ebs.androidutilbase.base.BottomBarTab;
import com.ebs.androidutilbase.first.FirstFragment;
import com.ebs.androidutilbase.first.FirstHomeFragment;
import com.ebs.androidutilbase.second.SecondFragment;
import com.ebs.androidutilbase.second.SecondHomeFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by barbaros.vasile on 12/7/2017.
 */

public class MainTabHostFragment extends SupportFragment {

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    SupportFragment[] mFragments;
    private BottomBar mBottomBar;


    public static MainTabHostFragment newInstance() {

        Bundle args = new Bundle();

        MainTabHostFragment fragment = new MainTabHostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_tabhost_fragment, container, false);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new SupportFragment[2];
        //mFragments[FIRST] = FirstFragment.newInstance();
        // mFragments[SECOND] = SecondFragment.newInstance();

        //loadMultipleRootFragment(R.id.root,0,mFragments);
        SupportFragment firstFragment = findFragment(FirstFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FirstFragment.newInstance();
            mFragments[SECOND] = SecondFragment.newInstance();

            loadMultipleRootFragment(R.id.main_tabhost_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(SecondFragment.class);
        }

    }

    private void initView() {


        mBottomBar.addItem(new BottomBarTab(getContext(), R.drawable.ic_home_white_24dp))
                .addItem(new BottomBarTab(getContext(), R.drawable.ic_discover_white_24dp));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();

                // 如果不在该类别Fragment的主页,则回到主页;
                if (count > 1) {
                    if (currentFragment instanceof FirstFragment) {
                        currentFragment.popToChild(FirstHomeFragment.class, false);
                    } else if (currentFragment instanceof SecondFragment) {
                        currentFragment.popToChild(SecondHomeFragment.class, false);
                    }
                    return;
                }


                // 这里推荐使用EventBus来实现 -> 解耦
                if (count == 1) {
                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                  //  EventBusActivityScope.getDefault(MainActivity.this).post(new TabSelectedEvent(position));
                }
            }
        });
    }
}
