package com.iss.jsonparser;


import com.iss.model.ISSPassTimes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalyan on 3/20/16.
 */
public class ISSPassTimesJSONParser {

    private static final String RISE_TIME = "risetime";
    private static final String DURATION = "duration";


    /***
     * Iterates the Passtimes dataand categorize it accordingly.
     * @param forecastArray JsonArray which is supposed to be categorized
     * @return the List of PassTimes data
     * @throws JSONException throws the JSONException if any error.
     */
    public static List<ISSPassTimes> getISSPasstimes(JSONArray forecastArray) throws JSONException {

        List<ISSPassTimes> issPassTimesList = new ArrayList<>();

        for (int i = 0; i < forecastArray.length(); i++) {

            ISSPassTimes issPassTimes = new ISSPassTimes();
            JSONObject issPassTimesResponse = forecastArray.getJSONObject(i);

            issPassTimes.setRisetime( issPassTimesResponse.getString(RISE_TIME));
            issPassTimes.setDuration( issPassTimesResponse.getString(DURATION));

            issPassTimesList.add(issPassTimes);


        }

        return issPassTimesList;
    }




}
