package com.fajarpnugroho.moviedb.ui.movie;

import com.fajarpnugroho.moviedb.model.response.Movie;

public interface DetailView {
    void onLoading(boolean loading);

    void showMovieDetail(Movie movie);
}
