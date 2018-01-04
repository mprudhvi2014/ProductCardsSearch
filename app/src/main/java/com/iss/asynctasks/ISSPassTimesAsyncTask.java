package com.iss.asynctasks;

import android.os.AsyncTask;

import com.iss.services.ISSPassTimesHTTPClient;
import com.iss.ui.fragments.ISSPassTimesActivityFragment;

import org.json.JSONObject;

/**
 * Created by Kalyan on 3/20/16.
 */
public class ISSPassTimesAsyncTask extends AsyncTask<Void, Void, JSONObject> {


    public interface IISSPassTimesCallBack {

        public void onISSPassTimeCallBack(JSONObject weather);
    }

    private ISSPassTimesActivityFragment mISSPasstimeActivityFragment;

    public ISSPassTimesAsyncTask(ISSPassTimesActivityFragment issPassTimesActivityFragment) {

        this.mISSPasstimeActivityFragment = issPassTimesActivityFragment;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        ISSPassTimesHTTPClient iss = new ISSPassTimesHTTPClient();
        JSONObject issData = ((iss).getISSPassTimeJSON());
        return issData;
    }

    @Override
    protected void onPostExecute(JSONObject issData) {
        super.onPostExecute(issData);

        mISSPasstimeActivityFragment.onISSPassTimeCallBack(issData);
    }


}