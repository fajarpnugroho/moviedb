package com.fajarpnugroho.moviedb;

import com.fajarpnugroho.moviedb.api.ApiModule;
import com.fajarpnugroho.moviedb.ui.movie.DetailActivity;
import com.fajarpnugroho.moviedb.ui.movies.MoviesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {
        ApplicationModule.class, ApiModule.class
})
public interface ApplicationComponent {
        void inject(DetailActivity activity);

        void inject(MoviesFragment fragment);
}
