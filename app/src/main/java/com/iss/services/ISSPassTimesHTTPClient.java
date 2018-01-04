package com.iss.services;

import android.util.Log;

import com.iss.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Kalyan on 3/19/16.
 */
public class ISSPassTimesHTTPClient {

    private static final String TAG = ISSPassTimesHTTPClient.class.getSimpleName();



    private static final String WEATHER_MAP_API =
            "http://api.open-notify.org/iss-pass.json?lat=45.0&lon=-122.3";
    private JSONObject weatherForeCastData;

    public JSONObject getISSPassTimeJSON() {
        try {
            weatherForeCastData = HttpUtils.processRequestandGetResponse(new URL(WEATHER_MAP_API));
        } catch (IOException ioException) {
            Log.e(TAG, ioException.getMessage());
        } catch (JSONException jsonException) {
            Log.e(TAG, jsonException.getMessage());

        }
        return weatherForeCastData;

    }
}
