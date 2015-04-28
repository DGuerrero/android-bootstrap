package com.quoders.apps.androidbootstrap.rest.retrofit;


import com.quoders.apps.androidbootstrap.rest.model.CommentItem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by davidguerrerodiaz on 23/04/15.
 */
public interface RestApi {

    @GET("/comments")
    void getComments(@Query("postId") String postNumber, Callback<List<CommentItem>> callback);


}

