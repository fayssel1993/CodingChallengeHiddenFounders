package com.faysselyabahddou.codingchallengehiddenfounders.github;

import com.faysselyabahddou.codingchallengehiddenfounders.model.Repo;

import java.util.List;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public interface GitHubContract {
    interface View {
        void onResponseReceived(List<Repo> response);

        void onEnableLoader(boolean enable);

        void onError(String title, String messages);

    }

    interface Presenter {
        void getRepos(boolean enableLoader, int page);
    }
}
