package com.faysselyabahddou.codingchallengehiddenfounders.github;

import com.faysselyabahddou.codingchallengehiddenfounders.app.CustomScope;
import com.faysselyabahddou.codingchallengehiddenfounders.app.NetComponent;

import dagger.Component;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
