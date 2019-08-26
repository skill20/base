package com.trust.library.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;

/**
 * Create by wangqingqing
 * On 2019/1/21 15:57
 * Copyright(c) 2018 极光
 * Description
 */
public class BaseFragment extends Fragment {

    protected Context mContext;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

}

