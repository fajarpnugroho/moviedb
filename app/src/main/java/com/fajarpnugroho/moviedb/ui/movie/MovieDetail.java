package com.fajarpnugroho.moviedb.ui.movie;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fajarpnugroho.moviedb.BaseActivity;
import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetail extends BaseActivity {


    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        long id = getIntent().getLongExtra(Constants.EXTRA_MOVIE_ID, -1);
        String movieData = getIntent().getStringExtra(Constants.EXTRA_MOVIE_DATA);

        getSupportFragmentManager().beginTransaction().add(R.id.content,
                MovieFragment.newInstance(id, movieData)).commit();

        setupToolbar();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() ==  null) {
            throw new IllegalStateException("Activity must implement toolbar.");
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
