package com.fajarpnugroho.moviedb.ui.movies;

import android.os.Bundle;
import android.widget.Toast;

import com.fajarpnugroho.moviedb.BaseActivity;
import com.fajarpnugroho.moviedb.Injector;
import com.fajarpnugroho.moviedb.R;
import com.fajarpnugroho.moviedb.api.ServiceConfig;
import com.fajarpnugroho.moviedb.api.service.MovieService;
import com.fajarpnugroho.moviedb.model.response.PopularResponse;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Inject MovieService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.INSTANCE.getApplicationComponent().inject(this);

        setContentView(R.layout.activity_main);

        Call<PopularResponse> call = service.popular(ServiceConfig.API_KEY);
        call.enqueue(new Callback<PopularResponse>() {
            @Override
            public void onResponse(Response<PopularResponse> response, Retrofit retrofit) {
                // STATUS CODE 200
                if (response.isSuccess()) {
                    Timber.v("SUCCESS");
                    PopularResponse popularResponse = response.body();
                    Toast.makeText(MainActivity.this, String.valueOf(popularResponse.page),
                            Toast.LENGTH_SHORT).show();
                } else {
                    // STATUS CODE 400
                    Timber.e("ERROR!!");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // NETWORK ERROR
            }
        });
    }
}
