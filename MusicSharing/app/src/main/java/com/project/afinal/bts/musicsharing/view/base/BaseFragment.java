package com.project.afinal.bts.musicsharing.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by verologu on 04/07/16.
 */
public class BaseFragment extends Fragment {

    protected int layoutId;
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(layoutId, container, false);

        parseFragmentArguments();
        loadViewItems();
        loadValues();

        return rootView;
    }

    protected void parseFragmentArguments() {

    }

    protected void loadViewItems() {

    }

    protected void loadValues() {

    }
}