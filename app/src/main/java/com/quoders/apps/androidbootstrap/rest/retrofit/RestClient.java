package com.quoders.apps.androidbootstrap.rest.retrofit;

import retrofit.RestAdapter;

/**
 * Created by davidguerrerodiaz on 19/04/15.
 */
public class RestClient {

    private static final String API_URL = "http://jsonplaceholder.typicode.com";

    private static RestApi mRestApi = null;


    public static synchronized RestApi getInstance() {

        if(mRestApi == null) {

            RestAdapter adapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(API_URL)
                    .build();

            mRestApi = adapter.create(RestApi.class);
        }

        return mRestApi;
    }
}
