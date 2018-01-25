package com.productcards.services;

import android.content.Context;
import android.util.Log;

import com.productcards.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
class ProductCardHTTPClient {

    private static final String TAG = ProductCardHTTPClient.class.getSimpleName();


    private StringBuilder PRODUCTS_CARDS_URL;

    private JSONArray mProductsData;

    public JSONArray getBBVAMapViewServiceCall(Context context) {
        try {
            PRODUCTS_CARDS_URL = new StringBuilder("https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json");
            mProductsData = HttpUtils.processRequestandGetResponse(new URL(PRODUCTS_CARDS_URL.toString()));
        } catch (IOException ioException) {
            Log.e(TAG, ioException.getMessage());
        } catch (JSONException jsonException) {
            Log.e(TAG, jsonException.getMessage());

        }
        return mProductsData;

    }
}
