package com.faysselyabahddou.codingchallengehiddenfounders.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}

