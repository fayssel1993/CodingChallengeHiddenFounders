package com.faysselyabahddou.codingchallengehiddenfounders.github;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.faysselyabahddou.codingchallengehiddenfounders.R;
import com.faysselyabahddou.codingchallengehiddenfounders.app.App;
import com.faysselyabahddou.codingchallengehiddenfounders.common.EndlessRecyclerOnScrollListener;
import com.faysselyabahddou.codingchallengehiddenfounders.common.PopUpMessage;
import com.faysselyabahddou.codingchallengehiddenfounders.model.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements GitHubContract.View {

    private RecyclerView recyclerView;
    private GitHubAdapter adapter;
    private ArrayList<Repo> repos;
    private ProgressBar loadMore;
    private PopUpMessage popUpMessage;
    private boolean mEnablePagination = true;
    private boolean mIsLoading;

    @Inject
    Application mApplication;
    @Inject
    GitHubPresenter gitHubPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerGitHubComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .gitHubModule(new GitHubModule(this))
                .build()
                .inject(this);

        bind();

        repos = new ArrayList<>();
        adapter = new GitHubAdapter(repos, this);
        popUpMessage = new PopUpMessage(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int current_page) {

                Log.d(TAG, "onLoadMore: " + current_page);
                if (mEnablePagination) {
                    mIsLoading = true;
                    gitHubPresenter.getRepos(true, current_page);
                }
            }
        });

        gitHubPresenter.getRepos(true, 1);
    }

    private void bind() {
        recyclerView = findViewById(R.id.recycler_view);
        loadMore = findViewById(R.id.progressLodMore);
    }

    @Override
    public void onResponseReceived(List<Repo> response) {
        if (mIsLoading) {
            mIsLoading = false;
            loadMore.setVisibility(View.GONE);
        } else if (response.isEmpty()) {
            mIsLoading = true;
        }
        repos.addAll(response);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onEnableLoader(boolean enable) {
        if (enable) {
            loadMore.setVisibility(View.VISIBLE);
        } else {
            loadMore.setVisibility(View.GONE);
        }
    }

    @Override
    public void onError(String title, String messages) {
        popUpMessage.showPopUp(title, messages);
    }
}
