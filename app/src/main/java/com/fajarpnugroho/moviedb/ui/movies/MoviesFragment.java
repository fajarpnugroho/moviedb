package com.fajarpnugroho.moviedb.ui.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fajarpnugroho.moviedb.Injector;
import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.model.response.MoviesResponse;
import com.fajarpnugroho.moviedb.presenter.MainPresenter;
import com.fajarpnugroho.moviedb.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoviesFragment extends BaseFragment implements MainView, SortableFragment {

    public static final int SPAN_COUNT = 2;

    private static final String DEFAULT_SORT = "popular";
    public static final String KEY_SORT = "key_sort";

    @Bind(R.id.recyclerview) RecyclerView recyclerView;
    @Bind(R.id.loading) ProgressBar loadingView;

    @Inject MainPresenter presenter;

    private MoviesAdapter adapter;
    private String sort;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Injector.INSTANCE.getApplicationComponent().inject(this);
        presenter.initView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(),
                SPAN_COUNT,
                LinearLayoutManager.VERTICAL,
                false);

        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MoviesAdapter();
        recyclerView.setAdapter(adapter);

        if (savedInstanceState == null) {
            sort = DEFAULT_SORT;
        } else {
            sort = savedInstanceState.getString(KEY_SORT);
        }

        presenter.loadMovie(sort);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_SORT, sort);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onLoading(boolean loading) {
        if (loading) {
            loadingView.setVisibility(View.VISIBLE);
        } else {
            loadingView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showListMovies(MoviesResponse popularResponse) {
        adapter.setMoviesData(popularResponse.results);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.label_retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.loadMovie(sort);
                    }
                })
                .show();
    }

    @Override
    public void sortMovie(String sort) {
        this.sort = sort;
        presenter.loadMovie(sort);
    }
}
