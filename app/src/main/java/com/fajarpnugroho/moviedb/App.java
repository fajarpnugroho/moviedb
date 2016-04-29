package com.fajarpnugroho.moviedb;

import android.app.Application;

import timber.log.Timber;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Injector.INSTANCE.initializeApplication(this);

        // Initalize Timber Log
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }
}
