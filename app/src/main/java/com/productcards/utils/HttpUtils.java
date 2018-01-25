package com.productcards.utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    private final static String CONTENT_TYPE = "Content-Type";
    private final static String APPLICATION_JSON = "application/json";
    private final static String NEW_LINE = "\n";

    public static JSONArray processRequestandGetResponse(URL productsCardsURL) throws IOException, JSONException {
        HttpURLConnection connection =
                (HttpURLConnection) productsCardsURL.openConnection();
        connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        StringBuffer json = new StringBuffer();
        String tmp = ProductCardsUtils.EMPTY;
        while ((tmp = reader.readLine()) != null)
            json.append(tmp);
        reader.close();

        JSONArray weatherData = new JSONArray(json.toString());
        return weatherData;
    }

}
