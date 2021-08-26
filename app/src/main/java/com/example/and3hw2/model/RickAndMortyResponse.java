package com.example.and3hw2.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RickAndMortyResponse<T> extends Character {
    @SerializedName("info")
    private Info info;

    @SerializedName("results")
    private ArrayList<T> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }
}
