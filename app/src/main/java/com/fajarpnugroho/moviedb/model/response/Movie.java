package com.fajarpnugroho.moviedb.model.response;

public class Movie {
    public final String posterPath;
    public final String overview;
    public final String releaseDate;
    public final long id;
    public final String originalTitle;
    public final String title;
    public final double popularity;
    public final int voteCount;
    public final double voteAverage;
    public final String tagline;

    public Movie(String posterPath, String overview, String releaseDate, long id,
                 String originalTitle, String title, double popularity, int voteCount,
                 int voteAverage, String tagline) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.id = id;
        this.originalTitle = originalTitle;
        this.title = title;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.tagline = tagline;
    }
}
