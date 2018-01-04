package com.iss.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iss.R;
import com.iss.model.ISSPassTimes;

import java.util.Date;
import java.util.List;

/**
 * Created by Kalyan on 3/19/16.
 */
public class ISSPassTimesListAdapter extends BaseAdapter {

    private List<ISSPassTimes> issPassTimes;
    private Context mContext;

    public ISSPassTimesListAdapter(List<ISSPassTimes> foreCast10Days, Context context) {
        issPassTimes = foreCast10Days;
        mContext = context;
    }

    @Override
    public int getCount() {
        return issPassTimes.size();
    }

    @Override
    public Object getItem(int position) {
        return issPassTimes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final WeatherViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.iss_past_time_list_adapter, parent, false);
            viewHolder = new WeatherViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (WeatherViewHolder) convertView.getTag();
        }

        String riseTime = issPassTimes.get(position).getRisetime();

        if (riseTime != null) {
            viewHolder.lblRiseTime.setText(new Date(Long.parseLong(riseTime)).toString());
        }

        viewHolder.lblDuration.setText(issPassTimes.get(position).getDuration());
        return convertView;

    }

    private class WeatherViewHolder {
        private TextView lblRiseTime;
        private TextView lblDuration;

        public WeatherViewHolder(@NonNull View convertView) {
            lblRiseTime = (TextView) convertView.findViewById(R.id.isstimeStamp);
            lblDuration = (TextView) convertView.findViewById(R.id.issTime);


        }


    }
}
