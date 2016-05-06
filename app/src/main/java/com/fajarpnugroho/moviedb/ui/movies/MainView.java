package com.fajarpnugroho.moviedb.ui.movies;

import com.fajarpnugroho.moviedb.model.response.MoviesResponse;

public interface MainView {
    public void onLoading(boolean loading);

    void showListMovies(MoviesResponse popularResponse);

    void showError(String message);
}
