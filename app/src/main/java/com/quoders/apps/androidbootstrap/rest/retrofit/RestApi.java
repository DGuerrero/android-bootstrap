package com.quoders.apps.androidbootstrap.rest.retrofit;


import com.quoders.apps.androidbootstrap.rest.model.CommentItem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by davidguerrerodiaz on 23/04/15.
 */
public interface RestApi {

    @GET("/comments")
    void getCommentsAsync(@Query("postId") String postNumber, Callback<List<CommentItem>> callback);


    @GET("/comments")
    List<CommentItem> getCommentsSync(@Query("postId") String postNumber);


    @POST("/comments")
    void postComment(@Body CommentItem item, Callback<CommentItem> cb);


    @Headers("Cache-Control: max-age=640000")
    @GET("/comments")
    List<CommentItem> getCommentsWithCustomHeader();
}

