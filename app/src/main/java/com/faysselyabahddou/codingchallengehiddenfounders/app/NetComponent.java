package com.faysselyabahddou.codingchallengehiddenfounders.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();

    Application application();
}