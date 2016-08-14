package com.dogzz.kedditd.api

import retrofit2.Call

/**
 * News API
 * Created by afon on 14.08.2016.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}