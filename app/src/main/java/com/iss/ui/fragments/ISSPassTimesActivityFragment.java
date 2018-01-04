package com.iss.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.iss.R;
import com.iss.adapters.ISSPassTimesListAdapter;
import com.iss.asynctasks.ISSPassTimesAsyncTask;
import com.iss.jsonparser.ISSPassTimesJSONParser;
import com.iss.model.ISSPassTimes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class ISSPassTimesActivityFragment extends Fragment implements ISSPassTimesAsyncTask.IISSPassTimesCallBack {

    private ListView mISSPassList;
    private TextView mNoResultsfound;
    private List<ISSPassTimes> mIssPasstimeList;
    private ISSPassTimesListAdapter mIssPasstimeListAdapter;

    public ISSPassTimesActivityFragment() {
    }


    public static ISSPassTimesActivityFragment newInstance() {
        return new ISSPassTimesActivityFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View weatherView = (View) inflater.inflate(R.layout.fragment_iss_pass_time_info, container, false);
        mISSPassList = (ListView) weatherView.findViewById(R.id.weather_list);
        mNoResultsfound = (TextView) weatherView.findViewById(R.id.noResults);
        AsyncTask<Void, Void, JSONObject> issPasstimesAsyncTask = new ISSPassTimesAsyncTask(ISSPassTimesActivityFragment.this);
        issPasstimesAsyncTask.execute((Void[]) null);
        return weatherView;
    }


    @Override
    public void onISSPassTimeCallBack(JSONObject weather) {

        try {
            if (weather != null) {
                mISSPassList.setVisibility(View.VISIBLE);
                mIssPasstimeList = ISSPassTimesJSONParser.getISSPasstimes(weather.getJSONArray("response"));
                mIssPasstimeListAdapter = new ISSPassTimesListAdapter(mIssPasstimeList, getActivity());
                mISSPassList.setAdapter(mIssPasstimeListAdapter);
            } else {
                mISSPassList.setVisibility(View.GONE);
                mNoResultsfound.setVisibility(View.VISIBLE);
            }

        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mIssPasstimeListAdapter != null)
            mISSPassList.setAdapter(mIssPasstimeListAdapter);

    }


}
