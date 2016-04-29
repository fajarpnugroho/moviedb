package com.fajarpnugroho.moviedb.ui.movies;

import com.fajarpnugroho.moviedb.model.response.PopularResponse;

public interface MainView {
    public void onLoading(boolean loading);

    void loadData(PopularResponse popularResponse);

    void showError(String message);
}
