package com.fajarpnugroho.moviedb.model.response;

import java.util.List;

public class MoviesResponse {
    public final int page;
    public final List<Movie> results;

    public MoviesResponse(int page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }
}
