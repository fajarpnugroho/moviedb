package com.fajarpnugroho.moviedb.presenter;

import com.fajarpnugroho.moviedb.model.MovieModel;
import com.fajarpnugroho.moviedb.model.response.MoviesResponse;
import com.fajarpnugroho.moviedb.ui.movies.MainView;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainPresenter {
    private MainView mainView;
    private MovieModel movieModel;

    @Inject
    public MainPresenter(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    public void initView(MainView mainView) {
        this.mainView = mainView;
    }

    public void loadMovie(String sort) {
        if (mainView != null) {
            mainView.onLoading(true);

            movieModel.listMovies(sort, new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Response<MoviesResponse> response, Retrofit retrofit) {
                    mainView.onLoading(false);
                    if (response.isSuccess()) {
                        // STATUS 200
                        mainView.showListMovies(response.body());
                    } else {
                        // STATUS 400
                        mainView.showError(response.message());
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    mainView.onLoading(false);
                    mainView.showError(t.getMessage());
                }
            });
        }
    }
}
