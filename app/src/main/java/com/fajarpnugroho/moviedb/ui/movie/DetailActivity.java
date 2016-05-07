package com.fajarpnugroho.moviedb.ui.movie;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fajarpnugroho.moviedb.BaseActivity;
import com.fajarpnugroho.moviedb.Injector;
import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.model.response.Movie;
import com.fajarpnugroho.moviedb.utils.Constants;
import com.fajarpnugroho.moviedb.utils.ImageSize;
import com.fajarpnugroho.moviedb.utils.ImageUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailView {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.root_header) RelativeLayout rootHeaderView;
    @Bind(R.id.poster) ImageView posterView;
    @Bind(R.id.title) TextView titleView;
    @Bind(R.id.rating_average) TextView ratingAverageView;
    @Bind(R.id.rating_bar) RatingBar ratingBarView;
    @Bind(R.id.synopsis) TextView synopsisView;
    @Bind(R.id.loading) ProgressBar loadingView;

    @Inject Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getApplicationComponent().inject(this);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupToolbar();

        Bundle bundle = getIntent().getExtras();

        int movieId = bundle.getInt(Constants.EXTRA_MOVIE_ID);
        String movieData = bundle.getString(Constants.EXTRA_MOVIE_DATA);

        setupHeader(movieData);

    }

    private void setupHeader(String movieData) {
        Movie movie = gson.fromJson(movieData, Movie.class);
        Uri uri = ImageUtils.movieUrl(ImageSize.w342.getValue(), movie.posterPath.replace("/", ""));
        Picasso.with(this).load(uri.toString()).into(posterView);

        titleView.setText(movie.title);
        ratingAverageView.setText(String.valueOf(movie.voteAverage));
        ratingBarView.setRating((float) movie.voteAverage);
        synopsisView.setText(movie.tagline);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar.");
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onLoading(boolean loading) {

    }

    @Override
    public void showMovieDetail(Movie movie) {

    }
}
