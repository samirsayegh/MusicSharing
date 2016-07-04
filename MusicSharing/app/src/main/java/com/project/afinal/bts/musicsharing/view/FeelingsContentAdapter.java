package com.project.afinal.bts.musicsharing.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.afinal.bts.musicsharing.R;

import java.util.List;

/**
 * Created by verologu on 04/07/16.
 */
public class FeelingsContentAdapter extends BaseAdapter {

    private List<FeelingsItem> items;

    public FeelingsContentAdapter(List<FeelingsItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_feelings, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.item_feelings_icon_iv);
        if (icon != null) {
            icon.setImageResource(items.get(position).getIconResource());
        }

        TextView title = (TextView) convertView.findViewById(R.id.item_feelings_title_tv);
        if (title != null) {
            title.setText(items.get(position).getTitle());
        }

        return convertView;
    }
}
