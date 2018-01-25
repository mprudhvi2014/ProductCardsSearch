package com.productcards.jsonparser;


import com.google.gson.reflect.TypeToken;
import com.productcards.model.ProductCardListResults;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class ProductCardsJSONParser {


    /***
     * This method converts all the jsonData to mapResultsList.
     * @param  mapData which is supposed to be parsed.
     * @return the List of FavoriteMapResultsModel data
     */
    public static List<ProductCardListResults> getProductsCardViewData(JSONArray mapData) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ProductCardListResults>>(){}.getType();

        List<ProductCardListResults> results = gson.fromJson(mapData.toString(),listType);
        return results;
    }


}
