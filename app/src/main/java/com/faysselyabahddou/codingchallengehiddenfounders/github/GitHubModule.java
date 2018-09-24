package com.faysselyabahddou.codingchallengehiddenfounders.github;

import com.faysselyabahddou.codingchallengehiddenfounders.app.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */

@Module
public class GitHubModule {

    private final GitHubContract.View view;

    public GitHubModule(GitHubContract.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    GitHubContract.View provideGitHubContractView() {
        return view;
    }
}
