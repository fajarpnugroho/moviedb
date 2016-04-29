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
import com.fajarpnugroho.moviedb.model.response.PopularResponse;
import com.fajarpnugroho.moviedb.presenter.MainPresenter;
import com.fajarpnugroho.moviedb.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoviesFragment extends BaseFragment implements MainView {

    public static final int SPAN_COUNT = 2;
    public static final int ITEM_SPACE = 16;
    @Bind(R.id.recyclerview) RecyclerView recyclerView;
    @Bind(R.id.loading) ProgressBar loadingView;

    @Inject MainPresenter presenter;

    private MoviesAdapter adapter;

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        return fragment;
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

        presenter.loadMovie();
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
    public void loadData(PopularResponse popularResponse) {
        adapter.setMovies(popularResponse.results);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.label_retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.loadMovie();
                    }
                })
                .show();
    }

}
