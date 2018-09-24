package com.faysselyabahddou.codingchallengehiddenfounders.github;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faysselyabahddou.codingchallengehiddenfounders.BuildConfig;
import com.faysselyabahddou.codingchallengehiddenfounders.R;
import com.faysselyabahddou.codingchallengehiddenfounders.model.Owner;
import com.faysselyabahddou.codingchallengehiddenfounders.model.Repo;

import java.util.ArrayList;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder> {
    private ArrayList<Repo> repos;
    private Context context;

    public GitHubAdapter(ArrayList<Repo> repos, Context context) {
        this.repos = repos;
        this.context = context;
    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_repo, viewGroup, false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder gitHubViewHolder, int position) {

        Repo repo = repos.get(position);
        Owner owner = repo.getOwner();
        //repo
        gitHubViewHolder.repoName.setText(repo.getName());
        gitHubViewHolder.repoDescription.setText(repo.getDescription());
        gitHubViewHolder.numberOfStars.setText(String.valueOf(repo.getStargazersCount()));
        //owner
        gitHubViewHolder.repoOwnerName.setText(owner.getLogin());

        Glide
                .with(context)
                .load(BuildConfig.AVATAR + owner.getId())
                .into(gitHubViewHolder.repoOwnerAvatar);
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    class GitHubViewHolder extends RecyclerView.ViewHolder {
        private TextView repoName;
        private TextView repoDescription;
        private TextView repoOwnerName;
        private TextView numberOfStars;
        private ImageView repoOwnerAvatar;

        public GitHubViewHolder(@NonNull View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_description);
            repoOwnerName = itemView.findViewById(R.id.repo_owner_name);
            numberOfStars = itemView.findViewById(R.id.number_of_stars);
            repoOwnerAvatar = itemView.findViewById(R.id.repo_owner_avatar);
        }
    }
}
