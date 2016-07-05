package com.project.afinal.bts.musicsharing.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by verologu on 04/07/16.
 */
public class FeelingsFragment extends BaseFragment {

    private String[] FEELINGS = {"Happy", "Sad", "Active", "Exhausted"};
    private GridView feelingsGrid;
    private Button next;

    public FeelingsFragment() {
        layoutId = R.layout.fragment_feelings_view;
    }

    @Override
    protected void loadViewItems() {
        feelingsGrid = (GridView) rootView.findViewById(R.id.fragment_feelings_gv);
        next = (Button) rootView.findViewById(R.id.fragment_feelings_next_b);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new PlayerFragment(), true);
            }
        });
    }

    @Override
    protected void loadValues() {
        ArrayList<FeelingsItem> items = new ArrayList<>();

        FeelingsItem item;
        for (int i = 0; i < FEELINGS.length; i++) {
            item = new FeelingsItem();
            item.setIconResource(R.drawable.ic_launcher);
            item.setTitle(FEELINGS[i]);
            items.add(item);
        }

        FeelingsContentAdapter adapter = new FeelingsContentAdapter(items);
        feelingsGrid.setAdapter(adapter);
        feelingsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplication().getApplicationContext(), ""
                        + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
