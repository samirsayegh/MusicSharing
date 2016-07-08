package com.project.afinal.bts.musicsharing.view;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;

/**
 * Created by verologu on 04/07/16.
 */
public class PlayerFragment extends BaseFragment {

    private TextView songQuestion;
    private ImageView playerIcon;
    private TextView songTitle;
    private TextView songArtist;
    private ImageView playerDislike;
    private ImageView playerLike;

    public PlayerFragment() {
        layoutId = R.layout.fragment_player_view;
    }

    @Override
    protected void loadViewItems() {
        songQuestion = (TextView) rootView.findViewById(R.id.fragment_player_view_song_question_tv);
        playerIcon = (ImageView) rootView.findViewById(R.id.fragment_player_view_song_play_iv);
        songTitle = (TextView) rootView.findViewById(R.id.fragment_player_view_song_artist_song_tv);
        songArtist = (TextView) rootView.findViewById(R.id.fragment_player_view_song_artist_name_tv);
        playerDislike = (ImageView) rootView.findViewById(R.id.fragment_player_view_song_dislike_iv);
        playerLike = (ImageView) rootView.findViewById(R.id.fragment_player_view_song_like_iv);
    }

    @Override
    protected void loadValues() {
        songQuestion.setText("What do you think about this song?");
        songTitle.setText("This is my song");
        songArtist.setText("John Doe");

        playerIcon.setImageResource(R.drawable.ic_play_circle_outline_white_48dp);
        playerIcon.setTag("play");
        playerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = (String) v.getTag();
                if ("play".equals(status)) {
                    playerIcon.setImageResource(R.drawable.ic_pause_circle_outline_white_48dp);
                    playerIcon.setTag("pause");
                } else {
                    playerIcon.setImageResource(R.drawable.ic_play_circle_outline_white_48dp);
                    playerIcon.setTag("play");
                }
            }
        });
        playerDislike.setImageResource(R.drawable.dislike);
        playerLike.setImageResource(R.drawable.like);
    }
}
