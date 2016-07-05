package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

/**
 * Created by veronica.lopez on 05/07/2016.
 */
public class MusicGenreFragment extends BaseFragment {

    private Button next;
    private TextView genre1;

    public MusicGenreFragment() {
        layoutId = R.layout.fragment_music_genre_view;
    }

    @Override
    protected void loadViewItems() {
        // TODO: gridview of genres!
        genre1 = (TextView) rootView.findViewById(R.id.fragment_music_genre_genre1_tv);

        next = (Button) rootView.findViewById(R.id.fragment_music_genre_next_b);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationManager.navigate(getActivity(), new PlayerFragment(), true);
            }
        });
    }

    @Override
    protected void loadValues() {
        genre1.setText("Pop");
    }
}
