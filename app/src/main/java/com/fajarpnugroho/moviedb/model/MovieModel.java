package com.fajarpnugroho.moviedb.model;

import com.fajarpnugroho.moviedb.api.ServiceConfig;
import com.fajarpnugroho.moviedb.api.service.MovieService;
import com.fajarpnugroho.moviedb.model.response.Movie;
import com.fajarpnugroho.moviedb.model.response.MoviesResponse;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;

public class MovieModel {

    private MovieService movieService;

    @Inject
    public MovieModel(MovieService movieService) {
        this.movieService = movieService;
    }

    public void listMovies(String sort, Callback<MoviesResponse> callback) {
        Call<MoviesResponse> call = movieService.listOfMovie(sort, ServiceConfig.API_KEY);
        call.enqueue(callback);
    }

    public void detailMovie(int id, Callback<Movie> callback) {
        Call<Movie> call = movieService.detailMovie(id);
        call.enqueue(callback);
    }
}
