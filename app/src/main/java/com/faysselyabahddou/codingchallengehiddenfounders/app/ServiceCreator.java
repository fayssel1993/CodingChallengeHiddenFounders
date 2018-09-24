package com.faysselyabahddou.codingchallengehiddenfounders.app;

import com.faysselyabahddou.codingchallengehiddenfounders.model.GitHubResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public interface ServiceCreator {

    @GET("search/repositories?q=created:>2018-08-24&sort=stars&order=desc")
    Single<GitHubResponse> getRepos(@Query("page") int page);
}
