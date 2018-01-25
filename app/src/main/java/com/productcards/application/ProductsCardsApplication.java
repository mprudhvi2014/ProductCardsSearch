package com.productcards.application;

import android.app.Application;

/**
 * Created by kalyann10 on 3/20/16.
 */
public class ProductsCardsApplication extends Application {

    private static ProductsCardsApplication productCardApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        productCardApplication = this;

    }

    public static ProductsCardsApplication getInstance() {
        return productCardApplication;
    }

}
