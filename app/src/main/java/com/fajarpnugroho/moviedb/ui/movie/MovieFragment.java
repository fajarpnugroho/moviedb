package com.fajarpnugroho.moviedb.ui.movie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.fajarpnugroho.moviedb.Injector;
import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.model.response.Movie;
import com.fajarpnugroho.moviedb.ui.BaseFragment;
import com.fajarpnugroho.moviedb.utils.ImageSize;
import com.fajarpnugroho.moviedb.utils.ImageUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieFragment extends BaseFragment {

    public static final String ARG_MOVIE_ID = "movie_id";
    public static final String ARG_MOVIE_DATA = "movie_data";

    @Bind(R.id.poster) ImageView posterView;
    @Bind(R.id.title) TextView titleView;
    @Bind(R.id.rating_average) TextView ratingAverageView;
    @Bind(R.id.rating_bar) RatingBar ratingBarView;
    @Bind(R.id.release_date) TextView releaseDateView;

    @Inject Gson gson;

    public static Fragment newInstance(long movieId, String movieData) {
        Bundle args = new Bundle();
        args.putLong(ARG_MOVIE_ID, movieId);
        args.putString(ARG_MOVIE_DATA, movieData);

        MovieFragment movieFragment = new MovieFragment();
        movieFragment.setArguments(args);
        return movieFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Injector.INSTANCE.getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Movie movie = gson.fromJson(getArguments().getString(ARG_MOVIE_DATA), Movie.class);

        Uri uri = ImageUtils.movieUrl(ImageSize.w342.getValue(), movie.posterPath);
        Picasso.with(getActivity()).load(uri.toString()).into(posterView);

        titleView.setText(movie.title);
        ratingAverageView.setText(String.valueOf(movie.voteAverage));
        ratingBarView.setRating((float) movie.voteAverage);
        releaseDateView.setText(movie.releaseDate);

    }
}
