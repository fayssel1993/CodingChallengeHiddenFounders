package com.faysselyabahddou.codingchallengehiddenfounders.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public class Repo {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("stargazers_count")
    @Expose
    private int stargazersCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repo repo = (Repo) o;
        return stargazersCount == repo.stargazersCount &&
                Objects.equals(name, repo.name) &&
                Objects.equals(owner, repo.owner) &&
                Objects.equals(description, repo.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, owner, description, stargazersCount);
    }

    @Override
    public String toString() {
        return "Repo{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                ", stargazersCount=" + stargazersCount +
                '}';
    }
}
