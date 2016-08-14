package com.dogzz.kedditd.features.news

import com.dogzz.kedditd.api.NewsAPI
import com.dogzz.kedditd.api.NewsRestAPI
import com.dogzz.kedditd.commons.RedditNews
import com.dogzz.kedditd.commons.RedditNewsItem
import rx.Observable

/**
 * News Manager allows you to request news from Reddit API.
 * provide a method that will return an Observable object which will allows you to run a piece of code
 * like an API call) in another context (in this case in a new thread).
 * Created by afon on 13.08.2016.
 */
class NewsManager(private val api: NewsAPI = NewsRestAPI()) {
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                var redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}