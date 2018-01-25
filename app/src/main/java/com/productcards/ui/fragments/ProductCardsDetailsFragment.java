package com.productcards.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.productcards.R;


public class ProductCardsDetailsFragment extends Fragment {

    private WebView webView;


    public ProductCardsDetailsFragment() {
    }

    public static ProductCardsDetailsFragment newInstance() {
        ProductCardsDetailsFragment fragment = new ProductCardsDetailsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_cards_details, container, false);
        webView = (WebView) view.findViewById(R.id.promocode_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        String url = getArguments().getString("url");
        webView.loadUrl(url);
        return view;
    }



}
