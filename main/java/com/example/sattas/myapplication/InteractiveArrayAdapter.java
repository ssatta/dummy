package com.example.sattas.myapplication;

/**
 * Created by sattas on 11/16/2014.
 */
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class InteractiveArrayAdapter extends ArrayAdapter<AlgoDisplayRow> {

    private final List<AlgoDisplayRow> list;
    private final Activity context;

    public InteractiveArrayAdapter(Activity context, List<AlgoDisplayRow> list) {
        super(context, R.layout.activity_list_activity_example, list);

        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.rowlayoutlist, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.algonamelive);
            viewHolder.thistime = (TextView) view.findViewById(R.id.time_collive);
            viewHolder.totaltime = (TextView) view.findViewById(R.id.avg_time_collive);
            view.setTag(viewHolder);

        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(list.get(position).getAlgoName());
        long timeTaken = list.get(position).getTimeTaken();
        holder.thistime.setText(Long.toString(timeTaken));
        long totalTimeTake = list.get(position).getAverageTimeTaken();
        holder.totaltime.setText(Long.toString(totalTimeTake));
        return view;
    }

    static class ViewHolder {
        protected TextView name;
        protected TextView thistime;
        protected TextView totaltime;
    }
}
