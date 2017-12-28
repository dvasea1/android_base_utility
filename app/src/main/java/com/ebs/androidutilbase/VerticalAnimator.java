package com.ebs.androidutilbase;

import android.os.Parcel;
import android.os.Parcelable;

import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by barbaros.vasile on 12/11/2017.
 */

public class VerticalAnimator extends FragmentAnimator implements Parcelable{

    public VerticalAnimator() {
        enter = R.anim.fragment_slide_in_bottom;
        exit = R.anim.fragment_slide_out_bottom;
        popEnter = R.anim.h_fragment_pop_enter;
        popExit = R.anim.h_fragment_pop_exit;
    }

    protected VerticalAnimator(Parcel in) {
        super(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VerticalAnimator> CREATOR = new Parcelable.Creator<VerticalAnimator>() {
        @Override
        public VerticalAnimator createFromParcel(Parcel in) {
            return new VerticalAnimator(in);
        }

        @Override
        public VerticalAnimator[] newArray(int size) {
            return new VerticalAnimator[size];
        }
    };
}