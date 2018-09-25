package com.faysselyabahddou.codingchallengehiddenfounders.github;

import android.app.Application;

import com.faysselyabahddou.codingchallengehiddenfounders.R;
import com.faysselyabahddou.codingchallengehiddenfounders.app.ServiceCreator;
import com.faysselyabahddou.codingchallengehiddenfounders.model.GitHubResponse;
import com.faysselyabahddou.codingchallengehiddenfounders.model.Repo;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public class GitHubPresenter implements GitHubContract.Presenter {

    private Retrofit retrofit;
    private GitHubContract.View view;

    @Inject
    Application application;

    @Inject
    public GitHubPresenter(Retrofit retrofit, GitHubContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void getRepos(boolean enableLoader, int page) {
        view.onEnableLoader(true);
        retrofit.create(ServiceCreator.class)
                .getRepos(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitHubResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        view.onError(application.getResources().getString(R.string.text_error), application.getResources().getString(R.string.text_error_message_app));

                    }

                    @Override
                    public void onNext(GitHubResponse gitHubResponse) {

                        view.onEnableLoader(false);
                        ArrayList<Repo> repos = gitHubResponse.getRepos();
                        view.onResponseReceived(repos);
                    }
                });


    }
}
