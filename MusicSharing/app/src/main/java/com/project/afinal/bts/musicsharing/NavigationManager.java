package com.project.afinal.bts.musicsharing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by verologu on 04/07/16.
 */
public class NavigationManager {

    public static void navigate(FragmentActivity activity, Fragment fragment,
                                boolean addToBackStack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        String fragmentTag = ((Object) fragment).getClass().getName();
        fragmentTransaction.replace(R.id.activity_main_fl, fragment, fragmentTag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragmentTag);
        }

        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    public static int getBackStackSize(FragmentActivity activity) {
        return activity.getSupportFragmentManager().getBackStackEntryCount();
    }
}