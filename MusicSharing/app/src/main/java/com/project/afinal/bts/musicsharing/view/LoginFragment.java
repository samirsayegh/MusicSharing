package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

import org.w3c.dom.Text;

/**
 * Created by Laia on 5/7/2016.
 */
public class LoginFragment extends BaseFragment {
    private TextView buttonLoginLogIN;
    private TextView buttonLoginDiscover;

    public LoginFragment(){
        layoutId = R.layout.fragment_login_view;
    }
    @Override
    protected void loadViewItems() {
        buttonLoginDiscover = (TextView) rootView.findViewById(R.id.buttonLoginDiscover);
        buttonLoginLogIN = (TextView) rootView.findViewById(R.id.buttonLoginLogIN);
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
