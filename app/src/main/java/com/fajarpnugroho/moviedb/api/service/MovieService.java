package com.fajarpnugroho.moviedb.api.service;

import com.fajarpnugroho.moviedb.model.response.MoviesResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface MovieService {
    /**
     * will return <BASE URL>"movie/popular?api_key=<API KEY>".
     * @param apiKey
     * @return
     */
    @Deprecated
    @GET("movie/popular")
    Call<MoviesResponse> popular(@Query("api_key") String apiKey);

    @Deprecated
    @GET("movie/top_rated")
    Call<MoviesResponse> topRated(@Query("api_key") String apiKey);

    /**
     * Return list of movies sort by popular or top rated.
     * @param sort
     * @param apiKey
     * @return
     */
    @GET("movie/{sort}")
    Call<MoviesResponse> listOfMovie(@Path("sort") String sort,
                                     @Query("api_key") String apiKey);
}
