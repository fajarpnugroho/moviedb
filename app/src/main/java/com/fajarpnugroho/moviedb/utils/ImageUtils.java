package com.fajarpnugroho.moviedb.utils;

import android.net.Uri;

import com.fajarpnugroho.moviedb.api.ServiceConfig;

public class ImageUtils {
    public static Uri movieUrl(String size, String posterPath) {
        posterPath = posterPath.replace("/", "");
        return Uri.parse(ServiceConfig.BASE_IMAGE_URL).buildUpon()
                .appendPath(size)
                .appendPath(posterPath)
                .build();
    }
}
