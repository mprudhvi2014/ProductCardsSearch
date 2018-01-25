package com.productcards.asynctasks;

import android.os.AsyncTask;

import com.productcards.jsonparser.ProductCardsJSONParser;
import com.productcards.model.ProductCardListResults;
import com.productcards.services.ProductCardHTTPClient;
import com.productcards.ui.fragments.ProductCardsListFragment;

import org.json.JSONArray;

import java.util.List;


public class ProductCardsAsyncTask extends AsyncTask<Void, Void, JSONArray> {

    private ProductCardsListFragment favoriteLocationListFragment;


    public ProductCardsAsyncTask(ProductCardsListFragment bbvaCompassFragment) {
        favoriteLocationListFragment = bbvaCompassFragment;

    }

    public interface ProductsCardsCallBack {
        public void onProductCardsCallBack(List<ProductCardListResults> mapDataList);
    }

    @Override
    protected JSONArray doInBackground(Void... voids) {
        ProductCardHTTPClient bbvaCompassHTTPClient = new ProductCardHTTPClient();
        JSONArray issData = ((bbvaCompassHTTPClient).getBBVAMapViewServiceCall(favoriteLocationListFragment.getActivity()));
        return issData;
    }

    @Override
    protected void onPostExecute(JSONArray productsCardsData) {

        super.onPostExecute(productsCardsData);
        favoriteLocationListFragment.onProductCardsCallBack(ProductCardsJSONParser.getProductsCardViewData(productsCardsData));

    }


}
