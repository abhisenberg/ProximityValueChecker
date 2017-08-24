package com.example.abheisenberg.proximitycheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abheisenberg on 23/8/17.
 */

public class adapter extends BaseAdapter {

    ArrayList<content> list;
    Context context;

    public adapter(ArrayList<content> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        content thisVal = list.get(i);

        holder h = null;
        if (view == null){
            view = li.inflate(R.layout.list_element, null);
            h = new holder();
            h.value = view.findViewById(R.id.tvProxVal);
            h.state = view.findViewById(R.id.tvState);
            h.time = view.findViewById(R.id.tvTime);
            view.setTag(h);
        } else {
            h = (holder) view.getTag();
        }

        h.value.setText(String.valueOf(thisVal.getPval()));
        h.state.setText(thisVal.getState());
        h.time.setText(String.valueOf(thisVal.getTime()));
        return view;

    }

    private static class holder {
        TextView value;
        TextView state;
        TextView time;
    }
}
