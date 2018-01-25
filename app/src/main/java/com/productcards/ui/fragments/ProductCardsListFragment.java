package com.productcards.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.productcards.adapters.ProductCardsListAdapter;
import com.productcards.asynctasks.ProductCardsAsyncTask;
import com.productcards.model.ProductCardListResults;
import com.productcards.ui.ProductCardsViewActivity;
import com.productcards.R;

import java.util.List;


public class ProductCardsListFragment extends Fragment implements ProductCardsAsyncTask.ProductsCardsCallBack {


    private ListView mProductsListView;

    public ProductCardsListFragment() {
    }

    public static ProductCardsListFragment newInstance() {
        return new ProductCardsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mapListView = inflater.inflate(R.layout.fragment_products_cards_list, container, false);
        mProductsListView = mapListView.findViewById(R.id.productsListView);
        ProductCardsAsyncTask productsCardsAsyncTask = new ProductCardsAsyncTask(this);
        productsCardsAsyncTask.execute();


        return mapListView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onProductCardsCallBack(List<ProductCardListResults> mapDataList) {
        ProductCardsListAdapter adapter = new ProductCardsListAdapter(mapDataList, (ProductCardsViewActivity) getActivity());
        mProductsListView.setAdapter(adapter);
    }
}
