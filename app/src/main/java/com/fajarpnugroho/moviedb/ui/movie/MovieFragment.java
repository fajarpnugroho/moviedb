package com.fajarpnugroho.moviedb.ui.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.ui.BaseFragment;

import butterknife.ButterKnife;

public class MovieFragment extends BaseFragment {

    public static final String ARG_MOVIE_ID = "movie_id";

    public static Fragment newInstance(int movieId) {
        Bundle args = new Bundle();
        args.putInt(ARG_MOVIE_ID, movieId);
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }
}
