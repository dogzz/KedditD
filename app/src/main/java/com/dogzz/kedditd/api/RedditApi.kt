package com.dogzz.kedditd.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit Interface for reddit api
 * Created by afon on 13.08.2016.
 */
interface  RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String): Call<RedditNewsResponse>;
}