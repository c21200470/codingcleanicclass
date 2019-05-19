package com.inflearn.lightinstagram.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.inflearn.lightinstagram.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected final String TAG = getClass().getSimpleName();
    protected Context context;
    protected BaseActivity activity;
    private Toolbar toolbar;

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar);
        if (toolbar != null) initializeToolbar(toolbar);
    }

    private void initialize() {
        context = getContext();
        activity = (BaseActivity) getActivity();
    }

    protected void initializeToolbar(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
    }
}