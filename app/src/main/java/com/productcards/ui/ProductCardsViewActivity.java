package com.productcards.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.productcards.ui.fragments.ProductCardsListFragment;
import com.productcards.R;

public class ProductCardsViewActivity extends AppCompatActivity {


    public static final String TAG = "ProductCardsViewActivity";
    private ProductCardsListFragment mProductListFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_cards_view);
        showProductListFragment();


    }

    private void showProductListFragment() {

        mProductListFragment = ProductCardsListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.mapViewContainer,
                        mProductListFragment)
                .commit();
        getSupportFragmentManager().executePendingTransactions();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}

