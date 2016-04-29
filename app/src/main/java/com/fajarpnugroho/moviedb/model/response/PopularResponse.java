package com.fajarpnugroho.moviedb.model.response;

import java.util.List;

public class PopularResponse {
    public final int page;
    public final List<Movie> results;

    public PopularResponse(int page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }
}
