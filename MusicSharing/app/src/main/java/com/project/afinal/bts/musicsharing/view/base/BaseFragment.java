package com.project.afinal.bts.musicsharing.view.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

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

    protected void hideKeyboard(){
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}