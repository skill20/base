package com.trust.library.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trust.library.R;
import com.trust.library.state.StatusLayoutManager;
import com.trust.library.view.TitleLayout;


/**
 * Create by wangqingqing
 * On 2019/4/2 14:30
 * Copyright(c) 2018 极光
 * Description
 */
public final class BaseRootDelegate implements NetworkState {

    private Activity activity;
    private View rootView;
    private BaseRootInterface rootInterface;

    private TitleLayout titleLayout;
    private StatusLayoutManager netStateManager;

    public BaseRootDelegate(Activity activity, BaseRootInterface rootInterface) {
        this.activity = activity;
        this.rootInterface = rootInterface;
    }

    public View getRootView() {
        return this.rootView;
    }


    public void onCreate(ViewGroup root) {
        if (rootView == null) {
            rootView = LayoutInflater.from(activity).inflate(R.layout.fragment_base, root, false);
        }

        findViewById(rootView);
    }

    private void findViewById(View v) {
        titleLayout = v.findViewById(R.id.title_layout);

        int rid = getContentLayout();
        if (rid <= 0) {
            throw new RuntimeException(
                    "BaseTitleFragment  don't have  content layout");
        }

        View view = View.inflate(activity, rid, null);
        LinearLayout mRootLayout = v.findViewById(R.id.layout_root);
        mRootLayout.addView(view, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        if (supportNetLayout()) {
            StatusLayoutManager.Builder builder = new StatusLayoutManager.Builder(view);
            setNetState(builder);
            netStateManager = builder.build();
        }
    }

    private void setNetState(StatusLayoutManager.Builder builder) {
        rootInterface.setNetStateBuilder(builder);
    }

    private int getContentLayout() {
        return rootInterface.getContentLayout();
    }

    private boolean supportNetLayout() {
        return rootInterface.supportNetLayout();
    }

    public StatusLayoutManager getNetStateManager() {
        return netStateManager;
    }

    public TitleLayout getTitleLayout() {
        return titleLayout;
    }


    @Override
    public void showLoading() {
        netStateManager.showLoadingLayout();
    }

    @Override
    public void showEmpty() {
        netStateManager.showEmptyLayout();
    }

    @Override
    public void showError() {
        netStateManager.showErrorLayout();
    }

    @Override
    public void showContent() {
        netStateManager.showSuccessLayout();
    }
}
