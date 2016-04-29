package com.fajarpnugroho.moviedb.model.response;


/**
 *  {
 "poster_path": "/5N20rQURev5CNDcMjHVUZhpoCNC.jpg",
 "adult": false,
 "overview": "Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.",
 "release_date": "2016-04-27",
 "genre_ids": [
 28,
 878,
 53
 ],
 "id": 271110,
 "original_title": "Captain America: Civil War",
 "original_language": "en",
 "title": "Captain America: Civil War",
 "backdrop_path": "/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg",
 "popularity": 61.250673,
 "vote_count": 244,
 "video": false,
 "vote_average": 6.23
 }
 */

public class Movie {
    public final String posterPath;
    public final String overview;
    public final String releaseDate;
    public final long id;
    public final String originalTitle;
    public final String title;
    public final long popularity;
    public final int voteCount;
    public final int voteAverage;

    public Movie(String posterPath, String overview, String releaseDate, long id,
                 String originalTitle, String title, long popularity, int voteCount,
                 int voteAverage) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.id = id;
        this.originalTitle = originalTitle;
        this.title = title;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }
}
