package com.alexsoft.androidcustomfragmentmanager;

import android.app.Application;

/**
 * Created by Alex on 30.01.2017.
 */

public class ApplicationController extends Application {
    private static ApplicationController mInstance;

    public static synchronized ApplicationController getInstance() {

        if (mInstance == null)
            mInstance = new ApplicationController();
        return mInstance;
    }

    private FragmentManager fragmentManager;

    @Override
    public void onCreate() {
        super.onCreate();
        fragmentManager = new FragmentManager(this);
        mInstance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        fragmentManager = null;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
