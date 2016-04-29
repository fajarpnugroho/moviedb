package com.fajarpnugroho.moviedb.presenter;

import com.fajarpnugroho.moviedb.api.ServiceConfig;
import com.fajarpnugroho.moviedb.api.service.MovieService;
import com.fajarpnugroho.moviedb.model.response.PopularResponse;
import com.fajarpnugroho.moviedb.ui.movies.MainView;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainPresenter {
    private MainView mainView;
    private MovieService movieService;

    @Inject
    public MainPresenter(MovieService movieService) {
        this.movieService = movieService;
    }

    public void initView(MainView mainView) {
        this.mainView = mainView;
    }

    public void loadMovie() {
        if (mainView != null) {
            mainView.onLoading(true);

            Call<PopularResponse> call = movieService.popular(ServiceConfig.API_KEY);
            call.enqueue(new Callback<PopularResponse>() {
                @Override
                public void onResponse(Response<PopularResponse> response, Retrofit retrofit) {
                    mainView.onLoading(false);
                    if (response.isSuccess()) {
                        // STATUS 200
                        mainView.loadData(response.body());
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
