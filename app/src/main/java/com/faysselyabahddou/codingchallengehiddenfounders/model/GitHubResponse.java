package com.faysselyabahddou.codingchallengehiddenfounders.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public class GitHubResponse {

    @SerializedName("items")
    @Expose
    private ArrayList<Repo> repos;

    public ArrayList<Repo> getRepos() {
        return repos;
    }

    public void setRepos(ArrayList<Repo> repos) {
        this.repos = repos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitHubResponse that = (GitHubResponse) o;
        return Objects.equals(repos, that.repos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(repos);
    }

    @Override
    public String toString() {
        return "GitHubResponse{" +
                "repos=" + repos +
                '}';
    }
}
