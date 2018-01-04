package com.iss.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.iss.R;
import com.iss.ui.fragments.ISSPassTimesActivityFragment;

public class ISSPassTimesInfoActivity extends AppCompatActivity {

    private static final String TAG = ISSPassTimesInfoActivity.class.getSimpleName();
    private ISSPassTimesActivityFragment mISSPassTimeActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iss_passtime__info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Load the Weather Information if the location is already set, or set the location if it is not set.
        showISSPasstimesFragment();
    }

    /***
     * This method navigates to WeatherInfoFragment which show the Weather details for next 10 days.
     */
    private void showISSPasstimesFragment() {


        mISSPassTimeActivityFragment = ISSPassTimesActivityFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.activity_container,
                        mISSPassTimeActivityFragment)
                .commit();

        getSupportFragmentManager().executePendingTransactions();
    }

}
