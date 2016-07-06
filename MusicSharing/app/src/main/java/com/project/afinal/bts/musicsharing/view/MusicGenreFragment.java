package com.project.afinal.bts.musicsharing.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;
import com.project.afinal.bts.musicsharing.view.base.BaseFragment;
import com.project.afinal.bts.musicsharing.view.model.GenreItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by veronica.lopez on 05/07/2016.
 */
public class MusicGenreFragment extends BaseFragment {

    private String[] GENRES = {"Pop", "(H)ip (H)op", "Indie", "Dance", "House"};
    private float[] TEXT_SIZES = {13, 16, 20, 14, 24};
    private int[] SIZES = {98, 80, 120, 73, 186};

    private TextView title;
    private LinearLayout musicGenres;
    private Button next;

    public MusicGenreFragment() {
        layoutId = R.layout.fragment_music_genre_view;
    }

    @Override
    protected void loadViewItems() {
        title = (TextView) rootView.findViewById(R.id.fragment_music_genre_title_tv);
        musicGenres = (LinearLayout) rootView.findViewById(R.id.fragment_music_genres_ll);

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
        title.setText("I like to hear...");
        next.setText("Next");

        final ArrayList<GenreItem> items = new ArrayList<>();

        GenreItem item1 = new GenreItem();
        item1.setTextSize(TEXT_SIZES[0]);
        item1.setName(GENRES[0]);
        item1.setSize(SIZES[0]);
        items.add(item1);

        GenreItem item2 = new GenreItem();
        item2.setTextSize(TEXT_SIZES[1]);
        item2.setName(GENRES[1]);
        item2.setSize(SIZES[1]);
        items.add(item2);

        GenreItem item3 = new GenreItem();
        item3.setTextSize(TEXT_SIZES[2]);
        item3.setName(GENRES[2]);
        item3.setSize(SIZES[2]);
        items.add(item3);

        GenreItem item4 = new GenreItem();
        item4.setTextSize(TEXT_SIZES[3]);
        item4.setName(GENRES[3]);
        item4.setSize(SIZES[3]);
        items.add(item4);

        GenreItem item5 = new GenreItem();
        item5.setTextSize(TEXT_SIZES[4]);
        item5.setName(GENRES[4]);
        item5.setSize(SIZES[4]);
        items.add(item5);

        createViews(items);
    }

    private void createViews(List<GenreItem> items) {
        int genrePosition = 0;
        for (int i = 0; i < GENRES.length % 3; i++) {
            FragmentActivity context = getActivity();
            LinearLayout horizontalContainer = createHorizontalContainer(context);
            View genre;
            for (int j = 0; j < 3; j++) {
                // create linear layout
                if (genrePosition == GENRES.length) {
                    break;
                }
                genre = createGenreView(items, genrePosition, context);
                horizontalContainer.addView(genre);
                genrePosition++;
            }
            musicGenres.addView(horizontalContainer);
        }
    }

    @NonNull
    private LinearLayout createHorizontalContainer(FragmentActivity context) {
        LinearLayout horizontalContainer = new LinearLayout(context);
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewParams.gravity = Gravity.CENTER_HORIZONTAL;
        horizontalContainer.setLayoutParams(viewParams);
        return horizontalContainer;
    }

    private View createGenreView(List<GenreItem> items, int i, FragmentActivity context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_music_genre, null);

        int margins = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10,
                getResources().getDisplayMetrics());
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewParams.setMargins(margins, margins, margins, margins);
        view.setLayoutParams(viewParams);

        TextView title = (TextView) view.findViewById(R.id.item_music_genre_name_tv);
        if (title != null) {
            GenreItem genreItem = items.get(i);
            int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, genreItem.getSize(),
                    getResources().getDisplayMetrics());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            title.setLayoutParams(params);
            title.setText(genreItem.getName());
            title.setTextSize(genreItem.getTextSize());

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

            /*
            RippleDrawable bgShape = (RippleDrawable) title.getBackground();
            bgShape.setColor(ColorStateList.valueOf(color));
            title.setBackground(bgShape);
            */

            GradientDrawable shape = (GradientDrawable) title.getBackground();
            shape.setColor(color);
        }

        return view;
    }
}
