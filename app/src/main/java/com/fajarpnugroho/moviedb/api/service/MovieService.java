package com.fajarpnugroho.moviedb.api.service;

import com.fajarpnugroho.moviedb.model.response.PopularResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MovieService {
    /**
     * will return <BASE URL>"movie/popular?api_key=<API KEY>".
     * @param apiKey
     * @return
     */
    @GET("movie/popular")
    Call<PopularResponse> popular(@Query("api_key") String apiKey);
}
