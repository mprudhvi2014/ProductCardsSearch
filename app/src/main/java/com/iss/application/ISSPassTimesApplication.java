package com.iss.application;

import android.app.Application;

/**
 * Created by kalyann10 on 3/20/16.
 */
public class ISSPassTimesApplication extends Application {

    private static ISSPassTimesApplication weatherApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        weatherApplication = this;

    }

    public static ISSPassTimesApplication getInstance() {
        return weatherApplication;
    }

}
