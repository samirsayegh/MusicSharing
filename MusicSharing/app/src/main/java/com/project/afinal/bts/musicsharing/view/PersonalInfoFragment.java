package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

/**
 * Created by yormirsamir.sayegh on 05/07/2016.
 * AIT Altran
 */
public class PersonalInfoFragment extends BaseFragment {

    private Spinner spinnerWhere;
    private Spinner spinnerWith;
    private Button buttonNext;

    public PersonalInfoFragment() {
        layoutId = R.layout.fragment_personal_info_view;
    }

    @Override
    protected void loadViewItems() {
        spinnerWhere = (Spinner) rootView.findViewById(R.id.spinnerPersonalInfoAt);
        spinnerWith = (Spinner) rootView.findViewById(R.id.spinnerPersonalInfoIAm);
        buttonNext = (Button) rootView.findViewById(R.id.buttonPersonalInfoAt);
        ArrayAdapter<CharSequence> adapterWhere = ArrayAdapter.createFromResource(getContext(),
                R.array.where, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterWith = ArrayAdapter.createFromResource(getContext(),
                R.array.with, android.R.layout.simple_spinner_item);
        adapterWhere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWhere.setAdapter(adapterWhere);
        adapterWith.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWith.setAdapter(adapterWith);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new FeelingsFragment(), true);
            }
        });
    }
}
