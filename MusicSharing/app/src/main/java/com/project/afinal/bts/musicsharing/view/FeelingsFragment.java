package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.adapter.FeelingsContentAdapter;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;
import com.project.afinal.bts.musicsharing.view.model.FeelingsItem;

import java.util.ArrayList;

/**
 * Created by verologu on 04/07/16.
 */
public class FeelingsFragment extends BaseFragment {

    private String[] FEELINGS = {"Happy", "Sad", "Active", "Exhausted"};
    private TextView title;
    private GridView feelingsGrid;
    private TextView next;

    public FeelingsFragment() {
        layoutId = R.layout.fragment_feelings_view;
    }

    @Override
    protected void loadViewItems() {
        title = (TextView) rootView.findViewById(R.id.fragment_feelings_title_tv);
        feelingsGrid = (GridView) rootView.findViewById(R.id.fragment_feelings_gv);
        next = (TextView) rootView.findViewById(R.id.fragment_feelings_next_b);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new MusicGenreFragment(), true);
            }
        });
    }

    @Override
    protected void loadValues() {
        title.setText("Today I feel like...");
        next.setText("Next");

        final ArrayList<FeelingsItem> items = new ArrayList<>();

        FeelingsItem item1 = new FeelingsItem();
        item1.setIconResource(R.drawable.joy);
        item1.setTitle(FEELINGS[0]);
        items.add(item1);

        FeelingsItem item2 = new FeelingsItem();
        item2.setIconResource(R.drawable.sad);
        item2.setTitle(FEELINGS[1]);
        items.add(item2);

        FeelingsItem item3 = new FeelingsItem();
        item3.setIconResource(R.drawable.active);
        item3.setTitle(FEELINGS[2]);
        items.add(item3);

        FeelingsItem item4 = new FeelingsItem();
        item4.setIconResource(R.drawable.exhausted);
        item4.setTitle(FEELINGS[3]);
        items.add(item4);

        FeelingsContentAdapter adapter = new FeelingsContentAdapter(items);
        feelingsGrid.setAdapter(adapter);
        feelingsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FeelingsItem feelingsItem = items.get(position);

                Toast.makeText(getActivity().getApplication().getApplicationContext(),
                        feelingsItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
