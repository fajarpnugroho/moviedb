package com.fajarpnugroho.moviedb.model.response;

import java.util.List;

public class PopularResponse {
    public final List<Movie> results;

    public PopularResponse(List<Movie> results) {
        this.results = results;
    }
}
