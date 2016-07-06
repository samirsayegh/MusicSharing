package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.Button;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

/**
 * Created by Laia on 5/7/2016.
 */
public class LoginFragment extends BaseFragment {
    private Button buttonLoginLogIN;
    private Button buttonLoginDiscover;

    public LoginFragment(){
        layoutId = R.layout.fragment_login_view;
    }
    @Override
    protected void loadViewItems() {
        buttonLoginDiscover = (Button) rootView.findViewById(R.id.buttonLoginDiscover);
        buttonLoginLogIN = (Button) rootView.findViewById(R.id.buttonLoginLogIN);
        buttonLoginDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new RegistrationFragment(), true);
            }

        });
        buttonLoginLogIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new PlayerFragment(), true);
            }

        });
    }
}
